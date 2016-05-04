package aeneas.controllers;

import aeneas.models.Square;
import aeneas.views.PieceView;

/**
 * listener for dragging
 * @author Logan
 *
 */
public interface ChildDraggedListener {

  /**
   * called when a piece is dragged
   * @param pieceView piece view being dragged
   */
  public void onPieceDragged(PieceView pieceView);

  /**
   * called when a square is dragged
   * @param squareView the squarevView being dragged
   */
  public void onSquareDragged(Square squareView);

}
