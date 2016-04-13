package kabasuji.controllers;
import kabasuji.models.Level;
import kabasuji.models.Piece;

/**
 * Move action to add a piece to a level
 * For use in the builder
 * 
 * @author Logan
 *
 */
public class AddPieceMove implements IMove {
  
  
  Level level;
  
  Piece piece;
  
  /**
   * Constructor
   * @param level the level that is being played
   * @param piece the piece to add
   */
  public AddPieceMove(Level level, Piece piece) {
    this.level = level;
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
