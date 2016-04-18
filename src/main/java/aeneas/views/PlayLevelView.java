package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import aeneas.controllers.SelectLevelController;
import aeneas.models.Level;
import aeneas.models.Piece;
import aeneas.models.Square;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PlayLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXButton resetLevelButton;

  @FXML
  private VBox bullpenBox;

  @FXML
  private Label levelLabel;

  @FXML
  private VBox centerBox;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  private MainView parentView;


  private BullpenView bullpenView;
  private BoardView boardView;
  private Level levelModel;

  PlayLevelView(MainView parentView, Level levelModel) {
    this.levelModel = levelModel;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayLevel.fxml"));
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

    resetLevelButton.setOnMouseClicked((e) -> {
      SelectLevelController c = new SelectLevelController(parentView, null);
      c.resetLevel();
    });

    Piece testPiece = new Piece(new Square[] {
          new Square(0, 0),
          new Square(1, 0),
          new Square(2, 1),
          new Square(2, 2),
          new Square(1, 1),
          new Square(1, 2), });

    bullpenView.addPiece(testPiece);

    boardView = new BoardView(levelModel.getBoard());
    VBox.setMargin(boardView, new Insets(10, 10, 10, 10));
    centerBox.setAlignment(Pos.TOP_RIGHT);
    centerBox.getChildren().add(boardView);
  }

}
