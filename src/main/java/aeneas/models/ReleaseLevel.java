package aeneas.models;

import java.util.ArrayList;

public class ReleaseLevel extends Level implements java.io.Serializable {
  public static final String helpText = "";

  ReleaseBoard board;
  ArrayList<ReleaseNumber> numbers;

  public ReleaseLevel(Bullpen bullpen, ArrayList<ReleaseNumber> numbers) {
    super(bullpen);
    this.numbers = numbers;
  }
  
  private boolean numberSetIsCovered(ReleaseNumber.Color color) {
    for(ReleaseNumber n : numbers) {
      if(n.color == color && board.getPieceAtLocation(n.row, n.col) != null) {
        return false;
      }
    }
    
    return true;
  }
  
  int numCoveredNumberSets() {
    int count = 0;
    count += numberSetIsCovered(ReleaseNumber.Color.RED) ? 1 : 0;
    count += numberSetIsCovered(ReleaseNumber.Color.GREEN) ? 1 : 0;
    count += numberSetIsCovered(ReleaseNumber.Color.BLUE) ? 1 : 0;

    return count;
  }
  
  @Override
  public int getStarsEarned() {
    int currentStars = Math.max(0, 3-numCoveredNumberSets());
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
