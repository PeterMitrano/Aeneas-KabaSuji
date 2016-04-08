package kabasuji.models;

import kabasuji.models.Level;;

public class GameModel {

  public int numLevels = 15;
  public Level[] levels;
  
  Level activeLevel;
  //?<Achievement> achievements;
  //ArrayList<IMove> undoStack;
  //ArrayList<IMove> redoStack;

  public GameModel() {
    levels = new Level[numLevels];
    for (int i = 0; i < numLevels; i++) {
      Level l = new Level();
      l.levelNumber = i + 1;
      levels[i] = l;
    }
  }
  
  void selectLevel(Level level) {
  }
  
  void setActiveLevel(Level level) {
  }

  void changeScreen(/**/) {
  }
  
  void updateStats() {
    
  }
  
  boolean undoLastMove() {
    return false;
  }
  
  boolean redoLastMove() {
    return false;
  }
}
