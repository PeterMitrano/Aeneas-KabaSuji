package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.controllers.SelectLevelController;
import aeneas.models.Level;
import aeneas.models.Piece;
import aeneas.models.Square;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PlayLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXButton resetLevelButton;

  @FXML
  private JFXListView bullpenListView;

  @FXML
  private Label levelLabel;

  @FXML
  private VBox centerBox;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  private MainView parentView;

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
    resetLevelButton.setOnMouseClicked((e) -> {
      SelectLevelController c = new SelectLevelController(parentView, null);
      c.resetLevel();
    });

    JFXDepthManager.setDepth(bullpenListView, 1);

    ArrayList<Pane> values = new ArrayList<Pane>();

    Piece[] pieces = new Piece[1];
    pieces[0] = new Piece(new Square[]{
      new Square(0, 0),
      new Square(1, 0),
      new Square(2, 1),
      new Square(2, 2),
      new Square(1, 1),
      new Square(1, 2),
    });

    int S = 16;
    for (Piece pieceModel : pieces) {

      // add a piece to the bullpen as an example
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(pieceModel, 16);
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
    }

    boardView = new BoardView(levelModel.getBoard());
    bullpenListView.setItems(FXCollections.observableList(values));
    centerBox.setMargin(boardView, new Insets(10, 10, 10, 10));
    centerBox.setAlignment(Pos.TOP_RIGHT);
    centerBox.getChildren().add(boardView);
  }

}
