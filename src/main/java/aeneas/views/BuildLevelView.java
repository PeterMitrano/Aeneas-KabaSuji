package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Level;
import aeneas.models.LightningLevel;
import aeneas.models.Piece;
import aeneas.models.PuzzleLevel;
import aeneas.models.ReleaseLevel;
import aeneas.models.Square;
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
  private JFXDatePicker timeSetter;

  @FXML
  private JFXButton saveButton;

  @FXML
  private ToggleGroup levelType;

  @FXML
  private JFXDatePicker timerSelect;

  @FXML
  private Spinner movesSelect;

  BoardView boardView;
  Level levelModel;
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

    saveButton.setOnMouseClicked(
        new SaveLevelController(parentView, levelModel));

    levelType.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,
                Toggle toggle, Toggle new_toggle) -> {
      String levelType = ((RadioButton)new_toggle).getText();
      switch (levelType) {
        case "Puzzle":
          levelModel = new PuzzleLevel(levelModel);
          break;
        case "Lightning":
          levelModel = new LightningLevel(levelModel);
          break;
        case "Release":
          levelModel = new ReleaseLevel(levelModel);
          break;
      }
    });
  }
}
