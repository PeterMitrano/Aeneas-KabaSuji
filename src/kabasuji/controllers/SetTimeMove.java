package kabasuji.controllers;
import kabasuji.models.LightningLevel;

/**
 * Move action to set the allotted time for a lightning level
 * For use in the builder
 * 
 * @author Logan
 *
 */
public class SetTimeMove implements IMove {
  
  
  LightningLevel level;
  
  int time;
  
  /**
   * Constructor
   * @param level the level that is being played
   * @param time the amount of time to set the level too
   */
  public SetTimeMove(LightningLevel level, int time) {
    this.level = level;
    this.time = time;
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
