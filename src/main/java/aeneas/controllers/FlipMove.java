package aeneas.controllers;
import aeneas.models.Piece;
import aeneas.models.Piece.Axis;

/**
 * Move action to flip a piece
 *
 * @author Logan
 *
 */
public class FlipMove implements IMove {


  Piece piece;
  Axis axis;

  /**
   * Constructor
   * @param piece The piece that is to be flipped
   */
  public FlipMove(Piece piece, Axis axis) {
    this.piece = piece;
    this.axis = axis;
  }

  @Override
  public boolean execute() {
    piece.flip(axis);
    return true;
  }

  @Override
  public boolean undo() {
    piece.flip(axis);
    return true;
  }

  @Override
  public boolean isValid() {
    return true;
  }

}
