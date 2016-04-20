package aeneas.models;

/**
 * 
 * @author Joseph Martin
 */
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
    return Math.max(0, 3 - bullpen.pieces.size());
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
