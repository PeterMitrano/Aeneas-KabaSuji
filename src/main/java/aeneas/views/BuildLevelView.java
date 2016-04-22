package aeneas.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import aeneas.models.Level;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
  private HBox settingsBox;

  @FXML
  private ToggleGroup levelType;

  @FXML
  private VBox togglesBox;

  private BoardView boardView;
  private Level levelModel;
  private MainView mainView;
  private BullpenView bullpenView;
  private LevelView levelView;

  BuildLevelView(MainView mainView, LevelView levelView) {
    this.levelView = levelView;
    this.levelModel = levelView.levelModel;
    this.mainView = mainView;
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
    bullpenView = new BullpenView(bullpenBox, this);

    boardView = new BoardView(levelModel.getBoard());
    VBox.setMargin(boardView, new Insets(10, 10, 10, 10));
    centerBox.setAlignment(Pos.TOP_RIGHT);
    centerBox.getChildren().add(boardView);

    saveButton.setOnMouseClicked((e) -> {
      File saveFile = mainView.showSaveDialog();
      if (saveFile == null) return;
      try {
        // We retrieve the current level live, because the current
        // level will change over time.
        this.levelModel.save(saveFile);
      } catch (IOException i) {
        System.out.println("Error occurred in opening file.");
      }
    });

    //these views are empty and really only used to get the radio buttons
    for (LevelView view : LevelViewFactory.getViews()) {
      view.getButton().setToggleGroup(levelType);
      togglesBox.getChildren().add(view.getButton());
    }

    //set the right settings got the given level type
    this.settingsBox.getChildren().add(1, this.levelView.getPanel());

    // Handle changes in the level type.
    // TODO: Consider moving this to a separate class.
    levelType.selectedToggleProperty()
        .addListener((ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) -> {
          if (new_toggle != null) {
            LevelView view = (LevelView) ((RadioButton) new_toggle).getUserData();
            this.levelModel  = view.levelModel;
            this.settingsBox.getChildren().set(1, view.getPanel());
          }
        });
  }

  public Level getLevel() {
    return levelModel;
  }
}
