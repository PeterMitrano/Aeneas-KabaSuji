package kabasuji.views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import kabasuji.models.Level;
import kabasuji.models.Piece;
import kabasuji.models.Square;

public class BuildLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXListView bullpenListView;

  @FXML
  private Label levelLabel;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  @FXML
  private VBox centerBox;

  BoardView boardView;

  Level levelModel;

  BuildLevelView(Level levelModel) {
    this.levelModel = levelModel;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/BuildLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    JFXDepthManager.setDepth(bullpenListView, 1);

    List<Pane> values = new ArrayList<Pane>();

    Piece[] pieces = new Piece[1];
    pieces[0] = new Piece();
    pieces[0].squares[0] = new Square(0,0);
    pieces[0].squares[1] = new Square(1,0);
    pieces[0].squares[2] = new Square(1,1);
    pieces[0].squares[3] = new Square(1,2);
    pieces[0].squares[4] = new Square(1,3);
    pieces[0].squares[5] = new Square(1,4);

    int S = 16;
    for (Piece pieceModel : pieces) {

      // add a piece to the bullpen as an example
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(pieceModel);
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
    }

    bullpenListView.setItems(FXCollections.observableList(values));

    boardView = new BoardView(levelModel.board);
    centerBox.getChildren().add(boardView);
  }
}
