package kabasuji.views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import kabasuji.models.Level;
import kabasuji.models.Piece;
import kabasuji.models.Square;

public class PlayLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXButton resetLevelButton;

  @FXML
  private JFXListView<Pane> bullpenListView;

  @FXML
  private Label levelLabel;

  @FXML
  private HBox centerBox;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  private BoardView boardView;
  private Level levelModel;

  PlayLevelView(Level levelModel) {
    this.levelModel = levelModel;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/PlayLevel.fxml"));
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
      System.out.println("reset");
    });

    JFXDepthManager.setDepth(bullpenListView, 1);

    ArrayList<Pane> values = new ArrayList<Pane>();

    Piece[] pieces = new Piece[1];
    pieces[0] = new Piece();
    pieces[0].squares[0] = new Square(1, 1);
    pieces[0].squares[1] = new Square(2, 1);
    pieces[0].squares[2] = new Square(3, 2);
    pieces[0].squares[3] = new Square(3, 3);
    pieces[0].squares[4] = new Square(2, 2);
    pieces[0].squares[5] = new Square(2, 3);

    for (Piece pieceModel : pieces) {

      // add a piece to the bullpen as an example
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(pieceModel, 16);
      piecePane.getChildren().add(pieceView);
      piecePane.setPrefSize(16*6, 16*6);
      values.add(piecePane);
    }

    boardView = new BoardView(levelModel.board.squares);
    bullpenListView.setItems(FXCollections.observableList(values));
    centerBox.getChildren().add(boardView);
  }

}
