package aeneas.models;

import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * 
 * @author Joseph Martin
 * @author Logan Tutt
 */
public class ReleaseLevel extends Level implements java.io.Serializable {
  public static final String helpText = "";

  ReleaseBoard board;


  public ReleaseLevel(Bullpen bullpen, ReleaseBoard board) {
    super(bullpen);
    this.board = board;
  }
  
  private boolean numberSetIsCovered(Color color) {
    for(ReleaseNumber n : board.getNumbers()) {
      if(n.color == color && board.getPieceAtLocation(n.row, n.col) == null) {
        return false;
      }
    }
    
    return true;
  }
  
  int numCoveredNumberSets() {
    int count = 0;
    count += numberSetIsCovered(ReleaseNumber.color1) ? 1 : 0;
    count += numberSetIsCovered(ReleaseNumber.color2) ? 1 : 0;
    count += numberSetIsCovered(ReleaseNumber.color3) ? 1 : 0;

    return count;
  }
  
  @Override
  public int getStarsEarned() {
    // This would have to change if we added more than 3 sets of numbers
    return numCoveredNumberSets();
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
