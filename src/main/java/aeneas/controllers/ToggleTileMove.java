package aeneas.controllers;
import aeneas.models.Board;
import aeneas.models.Model;

/**
 * Move action to toggle the state of a tile on the board
 * For use in the Builder
 *
 * @author Logan
 * @author Joseph Martin
 * @author Peter Mitrano
 */
public class ToggleTileMove implements IMove {
  Model model;

  int row;
  int col;

  /**
   * Constructor
   *
   * @param model The model that is currently being edited
   * @param row The row of tile to toggle
   * @param col The column of tile to toggle
   */
  public ToggleTileMove(Model model, int row, int col) {
    this.model = model;
    this.row = row;
    this.col = col;
  }

  @Override
  public boolean execute() {
    if(!isValid()) return false;
    boolean[][] squares = model.getActiveLevel().getBoard().getSquares();
    squares[row][col] = !squares[row][col];
    return true;
  }

  @Override
  public boolean undo() {
    return execute();
  }

  @Override
  public boolean isValid() {
    return row < Board.MAX_SIZE && col < Board.MAX_SIZE;
  }

}
