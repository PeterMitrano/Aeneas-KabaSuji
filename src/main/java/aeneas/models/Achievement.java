package aeneas.models;

/** 
 * achievements are locked or unlocked, and a name
 * 
 * @author Joseph Martin
 */
public abstract class Achievement implements java.io.Serializable {
  boolean unlocked;
  String name;

  public Achievement(String name, boolean unlocked) {
    this.unlocked = unlocked;
    this.name = name;
  }
  
  /**
   * Run to check if the achievement has been unlocked yet.
   * 
   * @param model The current game model
   * @return True if the achievement has been unlocked, false otherwise.
   */
  public abstract boolean checkUnlocked(Model model);
}
