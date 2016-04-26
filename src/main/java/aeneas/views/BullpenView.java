package aeneas.views;

import java.util.ArrayList;

import aeneas.controllers.ChildDraggedListener;
import aeneas.models.Bullpen;
import aeneas.models.Model;
import aeneas.models.Piece;
import aeneas.models.Square;

import javafx.geometry.Pos;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Joseph Martin
 */
public class BullpenView implements ChildDraggedListener {

  VBox bullpenBox;
  Pane levelView;
  private Model model;

  static final int SQUARE_SIZE = 14;
  private String baseStyle = "-fx-padding:10px;";

  ArrayList<Pane> values = new ArrayList<Pane>();

  public BullpenView(Model model, VBox bullpenBox, Pane levelView) {
    this.model = model;
    this.levelView = levelView;
    this.bullpenBox = bullpenBox;
    bullpenBox.setAlignment(Pos.TOP_CENTER);

    // This allows the bullpen to still be full height
    // when just a few pieces are added.
    bullpenBox.setMinHeight(550);

    // This handle the drop of a piece on the board
    bullpenBox.setOnDragDropped((DragEvent event) -> {
      Dragboard db = event.getDragboard();
      Piece pieceModel = (Piece) db.getContent(Piece.dataFormat);

      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(levelView, pieceModel, model, SQUARE_SIZE);
      pieceView.setOnChldDraggedListener(this);
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
      bullpenBox.getChildren().add(piecePane);

      // this might change we we actually implement it,
      // such as if they drop it on a square that doesn't exist
      event.setDropCompleted(true);
      event.consume();

    });

    // this is absolutely nessecary
    bullpenBox.setOnDragOver((DragEvent event) -> {
      event.acceptTransferModes(TransferMode.MOVE);
      event.consume();
    });

    bullpenBox.setOnDragExited((e) -> {
      bullpenBox.setStyle(baseStyle);
    });

    bullpenBox.setOnDragEntered((e) -> {
      bullpenBox.setStyle(baseStyle + "-fx-background-color:#E2E2E2;");
    });
  }

  public void refresh(Bullpen bullpen) {

    bullpenBox.getChildren().clear();

    for (int i = bullpen.getPieces().size() - 1; i >= 0; i--) {
      Piece piece = bullpen.getPieces().get(i);
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(levelView, piece, model, SQUARE_SIZE);
      pieceView.setOnChldDraggedListener(this);
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
      bullpenBox.getChildren().add(piecePane);
    }
  }

  @Override
  public void onPieceDragged(PieceView pieceView) {
    bullpenBox.getChildren().remove(pieceView.getParent());
  }

  @Override
  public void onSquareDragged(Square squareView) {
  }
}
