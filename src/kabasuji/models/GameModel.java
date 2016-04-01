package kabasuji.models;

public class GameModel {

  public int numLevels = 15;
  public LevelModel[] levels;

  public GameModel() {
    levels = new LevelModel[numLevels];
    for (int i = 0; i < numLevels; i++) {
      LevelModel l = new LevelModel();
      l.levelNumber = i + 1;
      levels[i] = l;
    }
  }

}
