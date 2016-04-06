package kabasuji.views;

import javafx.scene.layout.Pane;

import kabasuji.models.Piece;
import kabasuji.models.Square;

public class PieceView extends Pane {

  Piece pieceModel;

  public PieceView(Piece pieceModel, int squareSize) {
    this.pieceModel = pieceModel;
    for (Square s : pieceModel.squares) {
      SquareView view = new SquareView(s, squareSize);
      view.setX(s.dRow * squareSize);
      view.setY(s.dCol * squareSize);
      getChildren().add(view);
    }
  }
}
