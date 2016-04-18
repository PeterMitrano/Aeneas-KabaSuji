package aeneas.models;

import java.util.ArrayList;

import aeneas.controllers.IMove;;

public class Model {

  public static final String aboutText = "KabaSuji is a brilliant new puzzle game. "
      + "It is the visionary work of Dr. George T Heineman, "
      + "and has been judiciously implemented by Peter Mitrano, "
      + "James Kuszmaul, Joseph Martin, Logan Tutt, and Garrison Hefter.";
  public static final String helpText = "To begin playing the game, select a level that is unlocked. "
      + "To begin editing a level, select and existing level from the list or create a new one. "
      + "Achievements can also be viewed with the 'View Achievements' button.";

  public int numLevels = 15;
  public ArrayList<Level> levels;
  public final String helpString = "HELP";
  public final String aboutString = "ABOUT";

  Level activeLevel;
  ArrayList<Achievement> achievements;
  //TODO: Add these once we get move classes
  //ArrayList<IMove> undoStack;
  //ArrayList<IMove> redoStack;

  public Model() {
    levels = new ArrayList<Level>();
    for (int i = 0; i < numLevels; i++) {
      Bullpen b = new Bullpen(new ArrayList<>());
      Level l = new PuzzleLevel(b);
      l.levelNumber = i + 1;
      l.lock();
      levels.add(l);
    }

    //add custom level for example
    for (int i=0;i<20;i++){
      Bullpen b = new Bullpen(new ArrayList<>());
      Level l = new PuzzleLevel(b, false);
      l.prebuilt = false;
      l.levelNumber = i+16;
      levels.add(l);
    }

    //of course level 1 stars unlocked
    levels.get(0).unlock();
  }

  /**
   * Not sure why we have this *and* setActiveLevel
   * @param level the level to be selected
   */
  public void selectLevel(Level level) {
  }

  /**
   * Sets the current active level
   * @param level the new level
   */
  public void setActiveLevel(Level level) {
  }

  /**
   * Switch to the given screen
   */
  public void changeScreen(/*take argument for screen to go to*/) {
  }

  /**
   * Called to notify that some game state may have changed,
   * so achievements, etc. can be checked and updated.
   */
  public void updateStats() {
  }

  /**
   * Undoes the most recently made move, if possible
   * @return true if undo was successful, false otherwise
   */
  public boolean undoLastMove() {
    return false;
  }

  /**
   * Redoes the most recently undone move, if possible
   * @return true if redo was successful, false otherwise
   */
  public boolean redoLastMove() {
    return false;
  }
  
  public void addNewMove(IMove move){
    
  }
}
