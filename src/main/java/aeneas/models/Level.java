package aeneas.models;

public abstract class Level {
  Bullpen bullpen;
  
  public int levelNumber;
  public int starsEarned = 2;

  public Level(Bullpen bullpen) {
    this.bullpen = bullpen;
  }
  
  /**
   * Check if the level is done
   * @return true if the level is complete, false otherwise.
   */
  public abstract boolean isComplete();
  
  /**
   * Get the board for this level
   * @return The board used by this level.
   */
  public abstract Board getBoard();
}
