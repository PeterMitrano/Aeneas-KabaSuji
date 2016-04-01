package kabasuji.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import kabasuji.controllers.SelectLevelController;
import kabasuji.models.GameModel;

public class PlaySelectLevelView extends BorderPane implements Initializable {

  @FXML
  private GridPane levelGrid;

  private GameModel gameModel;

  private final int numCols = 5;

  PlaySelectLevelView(GameModel model) {
    this.gameModel = model;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/PlaySelectLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    }
    catch (IOException e){
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
    for (int r = 0; r < numRows; r++){
      for (int c = 0; c < numCols; c++){
        int levelIndex = numCols * r + c ;
        int levelNumber = levelIndex + 1;
        JFXButton button = new JFXButton();

        button.setPrefSize(100,100);
        button.getStyleClass().add("level-select-button");
        button.setButtonType(ButtonType.FLAT);
        button.setText(String.valueOf(levelNumber));
        button.applyCss();
        button.setOnMouseClicked(new SelectLevelController(gameModel.levels[levelIndex]));

        levelGrid.add(button, c, r);
      }
    }
  }
}
