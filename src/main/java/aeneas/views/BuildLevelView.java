package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Bullpen;
import aeneas.models.Level;
import aeneas.models.Level.LevelType;
import aeneas.models.LightningLevel;
import aeneas.models.Piece;
import aeneas.models.PuzzleLevel;
import aeneas.models.ReleaseLevel;
import aeneas.models.Square;
import aeneas.controllers.ChangeLevelTypeMove;
import aeneas.controllers.IMove;
import aeneas.controllers.LevelOptionsController;
import aeneas.controllers.SaveLevelController;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Display the level builder.
 *
 * @author pmitrano
 * @author jbkuszmaul
 */
public class BuildLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXListView<Pane> bullpenListView;

  @FXML
  private Label levelLabel;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  @FXML
  private VBox bullpenBox;

  @FXML
  private VBox centerBox;

  @FXML
  private JFXButton saveButton;

  @FXML
  private ToggleGroup levelType;

  @FXML
  private Toggle PuzzleRadio;

  @FXML
  private Toggle LightningRadio;

  @FXML
  private Toggle ReleaseRadio;

  @FXML
  private JFXDatePicker timerSelect;

  @FXML
  private Spinner<Double> movesSelect;

  @FXML
  private Label movesLabel;

  BoardView boardView;
  private Level levelModel;
  MainView parentView;
  BullpenView bullpenView;

  BuildLevelView(MainView parentView, Level levelModel) {
    this.levelModel = levelModel;
    this.parentView = parentView;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("BuildLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    bullpenView = new BullpenView(bullpenBox);

    Piece testPiece = new Piece(new Square[] {
        new Square(0, 0),
        new Square(1, 0),
        new Square(1, 1),
        new Square(1, 2),
        new Square(1, 3),
        new Square(1, 4),
    });

    bullpenView.addPiece(testPiece);

    boardView = new BoardView(levelModel.getBoard());
    VBox.setMargin(boardView, new Insets(10, 10, 10, 10));
    centerBox.setAlignment(Pos.TOP_RIGHT);
    centerBox.getChildren().add(boardView);

    saveButton.setOnMouseClicked(new SaveLevelController(parentView));

    // Handle changes in the level type.
    // TODO: Consider moving this to a separate class.
    levelType.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,
                Toggle toggle, Toggle new_toggle) -> {
      String levelName = ((RadioButton)new_toggle).getText();
      LevelType type = LevelType.fromString(levelName);
      IMove changeMove = new ChangeLevelTypeMove(this.getLevel(), this, type);
      if (changeMove.execute()) {
        //Model.registerMove(changeMove);
      }

      (new LevelOptionsController(this)).refreshLevel();
    });

    // Update the level options whenever the movesSelect spinner
    // is updated.
    movesSelect.valueProperty().addListener((obs, oldValue, newValue) -> {
      (new LevelOptionsController(this)).refreshLevel();
    });
  }

  /**
   * Sets the current level for the builder.
   *
   * This will update the current options selectors based on the new level.
   * @param level The new level to set; if null, a new default level will be
   *    put in.
   */
  public void setLevel(Level level) {
    if (level != null) {
      levelModel = level;
    } else {
      // Reset with defaults, level should NEVER be null.
      levelModel = new LightningLevel(new Bullpen(), 0);
    }

    boolean showMoves = levelModel.getLevelType() != LevelType.LIGHTNING;
    timerSelect.setVisible(!showMoves);
    movesSelect.setVisible(showMoves);
    // TODO: Why doesn't this actually hide the movesLabel?
    movesLabel.setVisible(showMoves);

    switch (levelModel.getLevelType()) {
      case LIGHTNING:
        int time = ((LightningLevel)levelModel).getAllowedTime();
        timerSelect.setTime(LocalTime.of(time / 60, time % 60));
        levelType.selectToggle(LightningRadio);
        break;
      case PUZZLE:
        movesSelect.valueFactoryProperty().getValue().setValue(
            new Double(((PuzzleLevel)levelModel).getAllowedMoves()));
        levelType.selectToggle(PuzzleRadio);
        break;
      case RELEASE:
        movesSelect.valueFactoryProperty().getValue().setValue(
            new Double(((ReleaseLevel)levelModel).getAllowedMoves()));
        levelType.selectToggle(ReleaseRadio);
        break;
    }
  }

  public Level getLevel() {
    return levelModel;
  }

  /**
   * Retrieve the number of allowed moves from the Spinner.
   */
  public int getMovesAllowed() {
    return movesSelect.getValue().intValue();
  }

  /**
   * Retrieve the number of allowed seconds from the DatePicker.
   */
  public int allowedSeconds() {
    LocalTime time = timerSelect.getTime();
    return time.getHour() * 60 + time.getMinute();
  }
}
