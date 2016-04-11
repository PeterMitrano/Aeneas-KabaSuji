package kabasuji.controllers;
import kabasuji.models.Level;

/**
 * Move action to toggle the state of a tile on the board
 * For use in the Builder
 * 
 * @author Logan
 *
 */
public class ToggleTileMove implements IMove {
  
  
  Level level;
  
  
  int row;
  int col;

  /**
   * Constructor
   * 
   * @param level The level that is currently being edited
   * @param row The row of tile to toggle
   * @param col The column of tile to toggle 
   */
  public ToggleTileMove(Level level, int row, int col) {
    this.level = level;
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
