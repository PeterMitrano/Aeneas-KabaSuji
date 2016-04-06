package kabasuji.views;

import javafx.scene.layout.Pane;

import kabasuji.models.Piece;
import kabasuji.models.Square;

public class PieceView extends Pane {

  public static final int SIZE = 16;// in pixels

  Piece pieceModel;

  public PieceView(Piece pieceModel){
    this.pieceModel = pieceModel;
    for (Square s : pieceModel.squares){
      SquareView view = new SquareView(s);
      view.setX(s.dRow * SIZE);
      view.setY(s.dCol * SIZE);
      getChildren().add(view);
    }
  }
}
