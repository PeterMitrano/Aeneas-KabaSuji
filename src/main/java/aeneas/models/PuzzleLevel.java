package aeneas.models;

public class PuzzleLevel extends Level implements java.io.Serializable {
  public static final String helpText = "";

  PuzzleBoard board;
  
  public PuzzleLevel(Bullpen bullpen) {
    super(bullpen);
  }

  public PuzzleLevel(Bullpen bullpen, boolean prebuilt) {
    super(bullpen, prebuilt);
  }
  

  @Override
  public int getStarsEarned() {
    int currentStars = Math.max(0, 3 - bullpen.pieces.size());
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
