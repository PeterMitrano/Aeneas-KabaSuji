package aeneas.controllers;

import aeneas.models.Square;
import aeneas.views.PieceView;

public interface ChildDraggedListener {

  public void onPieceDragged(PieceView pieceView);

  public void onSquareDragged(Square squareView);

}
