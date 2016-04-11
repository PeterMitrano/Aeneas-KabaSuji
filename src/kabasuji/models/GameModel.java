package kabasuji.models;

import java.util.ArrayList;

import kabasuji.models.Level;;

public class GameModel {

  public int numLevels = 15;
  public Level[] levels;
  
  Level activeLevel;
  ArrayList<Achievement> achievements;
  //ArrayList<IMove> undoStack;
  //ArrayList<IMove> redoStack;

  public GameModel() {
    levels = new Level[numLevels];
    for (int i = 0; i < numLevels; i++) {
      Bullpen b = new Bullpen(new ArrayList<>());
      Level l = new PuzzleLevel(b);
      l.levelNumber = i + 1;
      levels[i] = l;
    }
  }
  
  public void selectLevel(Level level) {
  }
  
  public void setActiveLevel(Level level) {
  }

  public void changeScreen(/**/) {
  }
  
  public void updateStats() {
    
  }
  
  public boolean undoLastMove() {
    return false;
  }
  
  public boolean redoLastMove() {
    return false;
  }
}
