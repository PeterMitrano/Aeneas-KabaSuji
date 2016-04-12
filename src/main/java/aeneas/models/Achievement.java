package aeneas.models;

public class Achievement {
  boolean unlocked;
  String name;
  
  Achievement(String name, boolean unlocked) {
    this.unlocked = unlocked;
    this.name = name;
  }
}
