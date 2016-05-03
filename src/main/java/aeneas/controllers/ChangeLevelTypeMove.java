package aeneas.controllers;
import aeneas.models.Level;
import aeneas.models.Model;

/**
 * Move action to change the type of a level
 * @author jbkuszmaul
 */
public class ChangeLevelTypeMove implements IMove {

  Level newLevel;
  Level oldLevel;
  Model model;

  /**
   * Constructor
   * @param model the current model
   * @param newLevel the level to change the model to
   */
  public ChangeLevelTypeMove(Model model, Level newLevel) {
    this.newLevel = newLevel;
    this.model = model;
  }

  @Override
  public boolean execute() {
    if (!isValid()) return false;
    this.oldLevel = model.getActiveLevel();
    model.setActiveLevel(newLevel);

    return true;
  }

  @Override
  public boolean undo() {
    model.setActiveLevel(oldLevel);
    return true;
  }

  /**
   * This move will be valid, unless oldLevel and newLevel are equal.
   */
  @Override
  public boolean isValid() {
    return !this.newLevel.equals(model.getActiveLevel());
  }

}
