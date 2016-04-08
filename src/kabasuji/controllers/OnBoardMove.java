package kabasuji.controllers;
import kabasuji.models.Level;
import kabasuji.models.PlacedPiece;

/**
 * Move action to move a piece from one location to another on the board
 * 
 * @author Logan
 *
 */
public class OnBoardMove implements IMove {
  
  
  Level level;
  
  PlacedPiece piece;
  
  int row;
  int col;

  /**
   * Constructor
   * @param level the level being played
   * @param piece the piece being moved
   * @param row the row to move the piece too
   * @param col the column to move the piece to
   */
  public OnBoardMove(Level level, PlacedPiece piece, int row, int col) {
    this.level = level;
    this.piece = piece;
    this.row = row;
    this.col = col;
  }
  
  @Override
  public boolean execute() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean undo() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isValid() {
    // TODO Auto-generated method stub
    return false;
  }

}
