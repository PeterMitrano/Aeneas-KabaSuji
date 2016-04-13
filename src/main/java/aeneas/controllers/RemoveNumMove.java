package aeneas.controllers;
import aeneas.models.ReleaseLevel;
import aeneas.models.ReleaseNumber;

/**
 * Move action to remove a release number from the board
 * For use in the builder
 *
 * @author Logan
 *
 */
public class RemoveNumMove implements IMove {


  ReleaseLevel level;

  ReleaseNumber num;

  /**
   * Constructor
   * @param level the level that is being played
   * @param num the ReleaseNUmber to remove
   */
  public RemoveNumMove(ReleaseLevel level, ReleaseNumber num) {
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
