package aeneas.models;

public class Achievement implements java.io.Serializable {
  boolean unlocked;
  String name;

  Achievement(String name, boolean unlocked) {
    this.unlocked = unlocked;
    this.name = name;
  }
}
