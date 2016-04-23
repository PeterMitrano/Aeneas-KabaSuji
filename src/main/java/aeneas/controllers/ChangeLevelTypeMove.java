package aeneas.controllers;
import aeneas.models.Level;

/**
 * Move action to change the type of a level
 */
public class ChangeLevelTypeMove implements IMove {

  Level newLevel;

  public ChangeLevelTypeMove(Level level) {
    this.newLevel = level;
  }

  @Override
  public boolean execute() {
    if (!isValid()) return false;

    return true;
  }

  @Override
  public boolean undo() {
    return true;
  }

  /**
   * This move will always be valid.
   */
  @Override
  public boolean isValid() {
    return true;
  }

}
