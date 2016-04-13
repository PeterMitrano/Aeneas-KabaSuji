package aeneas.controllers;
import aeneas.models.Level;
import aeneas.models.PlacedPiece;

/**
 * Move action to delete an existing hint
 * @author Logan
 *
 */
public class DeleteHintMove implements IMove {


  Level level;

  PlacedPiece piece;

  int row;
  int col;

  /**
   * Constructor
   *
   * @param level The level that is currently being played
   * @param piece The piece that is being deleted
   * @param row The row of the piece
   * @param col The column of the piece
   */
  public DeleteHintMove(Level level, PlacedPiece piece, int row, int col) {
    this.level = level;
    this.piece = piece;
    this.row = row;
    this.col = col;
  }

  @Override
  public boolean execute() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean undo() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isValid() {
    // TODO Auto-generated method stub
    return false;
  }

}
