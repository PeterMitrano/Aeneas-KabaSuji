package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;

import aeneas.controllers.SelectLevelController;
import aeneas.models.Level;
import aeneas.models.Model;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PlaySelectLevelView extends BorderPane implements Initializable {

  @FXML
  private GridPane levelGrid;

  private Model gameModel;

  public MainView parentView;

  private final int numCols = 5;

  PlaySelectLevelView(MainView parentView, Model model) {
    this.gameModel = model;
    this.parentView = parentView;

    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("PlaySelectLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @param location
   * @param resources
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    int numRows = gameModel.numLevels / numCols;

    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        int levelIndex = numCols * r + c;
        int levelNumber = levelIndex + 1;
        Level level = gameModel.levels.get(levelIndex);

        JFXButton button = new JFXButton();

        button.setPrefSize(100, 100);
        button.getStyleClass().add("level-select-button");
        button.setButtonType(ButtonType.FLAT);
        button.setText(String.valueOf(levelNumber));
        button.applyCss();
        button.setOnMouseClicked(new SelectLevelController(parentView, level));

        HBox stars = new HBox();
        stars.setMouseTransparent(true);
        stars.setAlignment(Pos.BOTTOM_CENTER);
        stars.setSpacing(2);
        for (int i = 0; i < level.starsEarned; i++) {
          FontAwesomeIconView star = new FontAwesomeIconView();
          star.setGlyphName("STAR");
          star.setSize("2em");
          star.setGlyphStyle("-fx-fill:#FFC107");
          stars.getChildren().add(star);
        }

        levelGrid.add(button, c, r);
        levelGrid.add(stars, c, r);
      }
    }
  }
}
