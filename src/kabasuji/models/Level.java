package kabasuji.models;

public abstract class Level {
  Bullpen bullpen;
  
  public int levelNumber;
  public int starsEarned = 2;

  public Level() {
  }
  
  public abstract boolean isComplete();
}
