package aeneas.views;

import java.util.ArrayList;

import com.jfoenix.effects.JFXDepthManager;

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

  static final int SQUARE_SIZE = 14;

  ArrayList<Pane> values = new ArrayList<Pane>();

  public BullpenView(VBox bullpenBox, Pane levelView){
    this.levelView = levelView;
    this.bullpenBox = bullpenBox;
    JFXDepthManager.setDepth(bullpenBox, 1);
    bullpenBox.setAlignment(Pos.TOP_CENTER);

    // This allows the bullpen to still be full height
    // when just a few pieces are added.
    bullpenBox.setMinHeight(550);
		bullpenBox.setStyle("-fx-background-color:#ff0;");
		bullpenBox.setStyle("-fx-padding:10px;");
  }

  public void refresh(Model model, Bullpen bullpen) {

    bullpenBox.getChildren().clear();

    for (int i=bullpen.getPieces().size() - 1; i >= 0; i-- ) {
      Piece piece = bullpen.getPieces().get(i);
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(levelView, piece, model, SQUARE_SIZE);
      pieceView.setOnChldDraggedListener(this);
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
      bullpenBox.getChildren().add(piecePane);
    }


    // This handle the drop of a piece on the board
    bullpenBox.setOnDragDropped((DragEvent event) -> {
      Dragboard db = event.getDragboard();
      Piece pieceModel = (Piece) db.getContent(Piece.dataFormat);

      System.out.println("dropped " + pieceModel.toString());

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

    //this is absolutely nessecary
    bullpenBox.setOnDragOver((DragEvent event) -> {
      event.acceptTransferModes(TransferMode.MOVE);
      event.consume();
    });
  }

  @Override
  public void onPieceDragged(PieceView pieceView) {
    bullpenBox.getChildren().remove(pieceView.getParent());
  }

  @Override
  public void onSquareDragged(Square squareView) {
  }
}
