package aeneas.controllers;
import aeneas.models.PuzzleLevel;

/**
 * Move action to set the allotted moves for a puzzle level
 * For use in the builder
 *
 * @author Logan
 *
 */
public class SetMovesMove implements IMove {


  PuzzleLevel level;

  int moves;

  /**
   * Constructor
   * @param level the level that is being edited
   * @param moves the amount of moves to set the level too
   */
  public SetMovesMove(PuzzleLevel level, int moves) {
    this.level = level;
    this.moves = moves;
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
