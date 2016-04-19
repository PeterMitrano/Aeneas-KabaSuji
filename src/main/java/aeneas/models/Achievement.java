package aeneas.models;

/** achievements are locked or unlocked, and a name
 */
public class Achievement implements java.io.Serializable {
  boolean unlocked;
  String name;

  Achievement(String name, boolean unlocked) {
    this.unlocked = unlocked;
    this.name = name;
  }
}
