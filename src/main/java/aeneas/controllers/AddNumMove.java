package aeneas.controllers;
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

  /**
   * Constructor
   * @param level the level that is being played
   * @param num the ReleaseNumber to be added
   */
  public AddNumMove(ReleaseLevel level, ReleaseNumber num) {
    this.level = level;
    this.num = num;
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
