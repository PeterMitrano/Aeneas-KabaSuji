package kabasuji.views;

import javafx.scene.layout.Pane;

import kabasuji.models.Piece;
import kabasuji.models.Square;

public class PieceView extends Pane {

  Piece pieceModel;

  public PieceView(Piece pieceModel, int squareSize) {
    this.pieceModel = pieceModel;
    for (Square s : pieceModel.getSquares()) {
      SquareView view = new SquareView(squareSize);
      view.setX(s.getRow() * squareSize);
      view.setY(s.getCol() * squareSize);
      getChildren().add(view);
    }
  }
}
