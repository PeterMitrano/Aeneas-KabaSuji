package kabasuji.controllers;
import kabasuji.models.Level;
import kabasuji.models.PlacedPiece;

/**
 * Move action to create a new hint
 * @author Logan
 *
 */
public class CreateHintMove implements IMove {
  
  
  Level level;
  
  PlacedPiece piece;
  
  int row;
  int col;

  /**
   * Constructor
   * 
   * @param level The level that is currently being played
   * @param piece The piece that is being used to make the hint
   * @param row The row to place the piece in 
   * @param col The column to place the piece in
   */
  public CreateHintMove(Level level, PlacedPiece piece, int row, int col) {
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
