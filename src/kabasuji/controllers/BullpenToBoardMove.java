package kabasuji.controllers;
import kabasuji.models.Level;
import kabasuji.models.PlacedPiece;

/**
 * Move action to move a piece from the bullpen to the board
 * @author Logan
 *
 */
public class BullpenToBoardMove implements IMove {
  
  
  Level level;
  
  PlacedPiece piece;
  
  int row;
  int col;

  /**
   * Constructor
   * 
   * @param level The level that is currently being played
   * @param piece The piece that is being moved
   * @param row The row to place the piece in 
   * @param col The column to place the piece in
   */
  public BullpenToBoardMove(Level level, PlacedPiece piece, int row, int col) {
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
