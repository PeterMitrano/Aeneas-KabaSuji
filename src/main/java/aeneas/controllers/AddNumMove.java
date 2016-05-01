package aeneas.controllers;
import aeneas.models.ReleaseBoard;
import aeneas.models.ReleaseLevel;
import aeneas.models.ReleaseNumber;

/**
 * Move action to add a number to a releae board
 * For use in the builder
 *
 * @author Logan
 *
 */
public class AddNumMove implements IMove {


  ReleaseLevel level;

  ReleaseNumber num;
  int row, col;

  /**
   * Constructor
   * @param level the level that is being played
   * @param num the ReleaseNumber to be added
   */
  public AddNumMove(ReleaseLevel level, ReleaseNumber num, int row, int col) {
    this.level = level;
    this.num = num;
    this.row = row;
    this.col = col;
  }

  @Override
  public boolean execute() {
    if (!isValid()) return false;
    ((ReleaseBoard) level.getBoard()).addNumber(num);
    return true;
  }

  @Override
  public boolean undo() {
    ((ReleaseBoard) level.getBoard()).removeNumber(num);
    return true;
  }

  @Override
  public boolean isValid() {
    return true;
  }

}
