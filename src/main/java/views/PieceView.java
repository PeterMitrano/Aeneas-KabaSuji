package main.java.views;

import javafx.scene.layout.Pane;
import main.java.models.Piece;
import main.java.models.Square;

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
