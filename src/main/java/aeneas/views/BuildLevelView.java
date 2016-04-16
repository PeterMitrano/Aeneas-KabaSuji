package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.effects.JFXDepthManager;

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

public class BuildLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXListView<Pane> bullpenListView;

  @FXML
  private Label levelLabel;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  @FXML
  private VBox centerBox;
  
  @FXML
  private JFXDatePicker timeSetter;

  BoardView boardView;

  Level levelModel;

  BuildLevelView(Level levelModel) {
    this.levelModel = levelModel;
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
    JFXDepthManager.setDepth(bullpenListView, 1);

    ArrayList<Pane> values = new ArrayList<Pane>();

    Piece[] pieces = new Piece[1];
    pieces[0] = new Piece(new Square[] {
        new Square(0, 0),
        new Square(1, 0),
        new Square(1, 1),
        new Square(1, 2),
        new Square(1, 3),
        new Square(1, 4),
    });

    int S = 16;
    for (Piece pieceModel : pieces) {

      // add a piece to the bullpen as an example
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(pieceModel, 16);
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
    }

    bullpenListView.setItems(FXCollections.observableList(values));

    boardView = new BoardView(levelModel.getBoard());
    centerBox.setMargin(boardView, new Insets(10, 10, 10, 10));
    centerBox.setAlignment(Pos.TOP_RIGHT);
    centerBox.getChildren().add(boardView);

  }
}
