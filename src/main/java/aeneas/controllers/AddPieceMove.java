package aeneas.controllers;

import aeneas.models.Bullpen;
import aeneas.models.Piece;

/**
 * Move action to add a piece to a level For use in the builder
 *
 * @author Logan
 *
 */
public class AddPieceMove implements IMove {

  Piece piece;
  Bullpen bullpen;

  /**
   * Constructor
   *
   * @param level
   *          the level that is being played
   * @param piece
   *          the piece to add
   */
  public AddPieceMove(Bullpen bullpen, Piece piece) {
    this.bullpen = bullpen;
    this.piece = piece;
  }

  @Override
  public boolean execute() {
    if (!isValid())
      return false;

    bullpen.addPiece(piece);

    return true;
  }

  @Override
  public boolean undo() {
    if (!isValid())
      return false;

    bullpen.removePiece(piece);

    return true;
  }

  @Override
  public boolean isValid() {
    if (bullpen == null || piece == null) {
      return false;
    }

    return bullpen.getLogic().isCanAddNewPiece();
  }
}
