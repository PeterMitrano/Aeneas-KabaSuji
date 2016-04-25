package aeneas.views;

import java.util.ArrayList;

import com.jfoenix.effects.JFXDepthManager;

import aeneas.controllers.ChildDraggedListener;
import aeneas.models.Bullpen;
import aeneas.models.Model;
import aeneas.models.Piece;
import aeneas.models.Square;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Joseph Martin
 */
public class BullpenView implements ChildDraggedListener {

  VBox bullpenBox;
  Pane levelView;

  static final int SQUARE_SIZE = 16;

  ArrayList<Pane> values = new ArrayList<Pane>();

  public BullpenView(VBox bullpenBox, Pane levelView){
    this.levelView = levelView;
    this.bullpenBox = bullpenBox;
    JFXDepthManager.setDepth(bullpenBox, 1);
    bullpenBox.setAlignment(Pos.TOP_CENTER);
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
  }

  @Override
  public void onPieceDragged(PieceView pieceView) {
    System.out.println(bullpenBox.getChildren().remove(pieceView.getParent()));
  }

  @Override
  public void onSquareDragged(Square squareView) {
  }
}
