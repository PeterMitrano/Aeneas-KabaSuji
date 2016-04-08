package kabasuji.controllers;
import kabasuji.models.Level;
import kabasuji.models.PlacedPiece;

/**
 * Move action to rotate a piece
 * 
 * @author Logan
 *
 */
public class RotateMove implements IMove {
  
  
  PlacedPiece piece;
  
  /**
   * Constructor
   * @param piece The piece that is to be rotated
   */
  public RotateMove(Piece piece) {
    this.piece = piece;
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
