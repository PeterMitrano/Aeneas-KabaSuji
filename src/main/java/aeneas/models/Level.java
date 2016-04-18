package aeneas.models;

public abstract class Level implements java.io.Serializable {
  Bullpen bullpen;

  public int levelNumber;
  public int starsEarned;
  boolean prebuilt;

  private boolean locked;

  public Level(Bullpen bullpen, boolean prebuilt) {
    this.bullpen = bullpen;
    this.prebuilt = prebuilt;
    this.starsEarned = 0;
  }

  public Level(Bullpen bullpen) {
    this(bullpen, true);
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

  public abstract int getStarsEarned();

  /**
   * @return the prebuilt
   */
  public boolean isPrebuilt() {
    return prebuilt;
  }

  /**
   * @return the locked
   */
  public boolean isLocked() {
    return locked;
  }

  public void unlock() {
    this.locked = false ;
  }

  public void lock() {
    this.locked = true;
  }
}
