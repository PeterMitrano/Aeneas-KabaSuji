package aeneas.controllers;
import aeneas.models.Level;
import aeneas.models.Piece;

/**
 * Move action to remove a piece from the level
 * @author Logan
 *
 */
public class RemovePieceMove implements IMove {


  Level level;

  Piece piece;


  /**
   * Constructor
   *
   * @param level The level that is currently being edited
   * @param piece The piece that is being removed
   */
  public RemovePieceMove(Level level, Piece piece) {
    this.level = level;
    this.piece = piece;
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
