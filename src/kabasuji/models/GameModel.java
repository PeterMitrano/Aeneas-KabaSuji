package kabasuji.models;

import kabasuji.models.Level;;

public class GameModel {

  public int numLevels = 15;
  public Level[] levels;

  public GameModel() {
    levels = new Level[numLevels];
    for (int i = 0; i < numLevels; i++) {
      Level l = new Level();
      l.levelNumber = i + 1;
      levels[i] = l;
    }
  }

}
