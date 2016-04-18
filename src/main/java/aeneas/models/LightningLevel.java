package aeneas.models;

public class LightningLevel extends Level implements java.io.Serializable {
  public static final String helpText = "";

  LightningBoard board;
  int allowedTime;

  public LightningLevel(Bullpen bullpen, int allowedTime) {
    super(bullpen);
    this.allowedTime = allowedTime;
  }  

  @Override
  public int getStarsEarned() {
    int currentStars =  Math.max(0, 3 - (board.numValidSquares()-board.numCoveredSquares()+5)/6);
    this.starsEarned = Math.max(this.starsEarned, currentStars);
    return this.starsEarned;
  }

  @Override
  public boolean isComplete() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Board getBoard() {
    return board;
  }
}
