package aeneas.models;

import java.util.ArrayList;

/**
 * 
 * @author Joseph Martin
 */
public class ReleaseLevel extends Level implements java.io.Serializable {
  public static final String helpText = "";

  ReleaseBoard board;

  public ReleaseLevel(Bullpen bullpen, ReleaseBoard board) {
    super(bullpen);
    this.board = board;
  }
  
  private boolean numberSetIsCovered(ReleaseNumber.Color color) {
    for(ReleaseNumber n : board.getNumbers()) {
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
    return Math.max(0, 3-numCoveredNumberSets());
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
