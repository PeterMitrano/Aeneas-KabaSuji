package kabasuji.views;

import javafx.scene.layout.Pane;

import kabasuji.models.Piece;
import kabasuji.models.Square;

public class PieceView extends Pane {

  Piece pieceModel;

  private static final int SPACING = 1; // pixels

  public PieceView(Piece pieceModel, int squareSize) {
    this.pieceModel = pieceModel;
    for (Square s : pieceModel.squares) {
      SquareView view = new SquareView(s, squareSize);
      view.setX(s.dRow * (squareSize + SPACING));
      view.setY(s.dCol * (squareSize + SPACING));
      view.setColor(SquareColor.GREEN);
      getChildren().add(view.getRectangle());
    }
  }
}
