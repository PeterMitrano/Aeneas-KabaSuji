package aeneas.views;

import aeneas.models.Piece;
import aeneas.models.Square;

import javafx.scene.layout.Pane;

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
