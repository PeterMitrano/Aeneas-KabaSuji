package kabasuji.models;

public abstract class Level {
  Bullpen bullpen;
  
  public int levelNumber;
  public int starsEarned = 2;

  public Level(Bullpen bullpen) {
    this.bullpen = bullpen;
  }
  
  public abstract boolean isComplete();
  public abstract Board getBoard();
}
