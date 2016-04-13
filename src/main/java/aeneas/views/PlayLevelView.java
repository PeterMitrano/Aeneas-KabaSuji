package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.effects.JFXDepthManager;

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
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PlayLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXButton resetLevelButton;

  @FXML
  private VBox bullpen;

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

    JFXDepthManager.setDepth(bullpen, 1);

    ArrayList<Pane> values = new ArrayList<Pane>();

    Piece testPiece = new Piece(new Square[] { new Square(0, 0), new Square(1, 0), new Square(2, 1), new Square(2, 2),
        new Square(1, 1), new Square(1, 2), });

    // add a piece to the bullpen as an example
    Pane piecePane = new Pane();
    PieceView pieceView = new PieceView(testPiece, 16);
    pieceView.setId("PieceView_" + System.currentTimeMillis());
    piecePane.getChildren().add(pieceView);

    values.add(piecePane);

    pieceView.setOnDragDetected((MouseEvent event) -> {
      Dragboard db = pieceView.startDragAndDrop(TransferMode.MOVE);
      ClipboardContent content = new ClipboardContent();

      //this is what we use to get the object on the other end
      content.putString(pieceView.toString());

      db.setContent(content);

      SnapshotParameters snapshotParameters = new SnapshotParameters();
      snapshotParameters.setFill(Color.TRANSPARENT);

      PieceView fullSizedPieceView = new PieceView(testPiece, BoardView.SQUARE_SIZE);

      Image snapshotImage = fullSizedPieceView.snapshot(snapshotParameters, null);
      db.setDragView(snapshotImage);

      event.consume();
    });

    boardView = new BoardView(levelModel.getBoard());
    bullpen.getChildren().add(piecePane);
    bullpen.setAlignment(Pos.TOP_CENTER);
    VBox.setMargin(boardView, new Insets(10, 10, 10, 10));
    centerBox.setAlignment(Pos.TOP_RIGHT);
    centerBox.getChildren().add(boardView);
  }

}
