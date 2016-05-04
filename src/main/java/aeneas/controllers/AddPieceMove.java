package aeneas.controllers;

import aeneas.models.Bullpen;
import aeneas.models.Piece;

/**
 * Move action to add a piece to a level For use in the builder
 *
 * @author Logan
 * @author Joseph Martin
 * @author jbkuszmaul
 */
public class AddPieceMove implements IMove {

  Piece piece;
  Bullpen bullpen;

  /**
   * Constructor
   *
   * @param bullpen the bullpen that the piece is being added to
   * @param piece the piece to add
   */
  public AddPieceMove(Bullpen bullpen, Piece piece) {
    this.bullpen = bullpen;
    this.piece = piece;
  }

  /**
   * @return true on success
   */
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

  /**
   * @return true on success
   */
  @Override
  public boolean isValid() {
    if (bullpen == null || piece == null) {
      return false;
    }

    return bullpen.getLogic().isCanAddNewPiece();
  }
}
