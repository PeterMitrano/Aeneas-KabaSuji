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


  /**
   * Constructor
   * @param bullpen The bullpen to use for this level
   * @param board The board to use for this level
   */
  public PuzzleLevel(Bullpen bullpen, PuzzleBoard board){
    super(bullpen);
    this.board = board;
  }

  /**
   * Constructor. Will create a new, empty board for this level
   * @param bullpen The bullpen to use for this level
   */
  public PuzzleLevel(Bullpen bullpen) {
    super(bullpen);
    board = new PuzzleBoard();
  }

  public PuzzleLevel(Bullpen bullpen, boolean prebuilt) {
    super(bullpen, prebuilt);
    board = new PuzzleBoard();
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
