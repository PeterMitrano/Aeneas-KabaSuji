package aeneas.models;

import aeneas.views.LevelView;
import aeneas.views.PuzzleView;

/**
 *
 * @author Joseph Martin
 */
public class PuzzleLevel extends Level
    implements java.io.Serializable, Level.LevelWithMoves {
  public static final String helpText = "";

  PuzzleBoard board;

  private int moves;

  public PuzzleLevel(Bullpen bullpen) {
    super(bullpen);
  }

  public PuzzleLevel(Bullpen bullpen, boolean prebuilt) {
    super(bullpen, prebuilt);
  }


  public PuzzleLevel(Level src) {
    super(src);
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

  @Override
  public void setAllowedMoves(int moves) { this.moves = moves; }

  @Override
  public int getAllowedMoves() { return moves; }

  @Override
  public LevelView makeCorrespondingView() {
    return new PuzzleView(this);
  }
}
