package aeneas.controllers;
import aeneas.models.Board;
import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.views.BuildLevelView;

/**
 * Set the number of rows/columns for the board.
 *
 * @author jbkuszmaul
 */
public class SetSizeMove implements IMove {
  Level oldLevel;
  Model model;

  int rows;
  int cols;
  int oldRows;
  int oldCols;

  boolean[][] old_squares;

  /**
   * Constructor
   *
   * @param level The level being edited.
   * @param rows The number of rows to set the board to have (1-Board.SIZE).
   * @param cols The number of columns to set the board to have (1-Board.SIZE).
   * @param old_rows The previous number of rows the board had.
   * @param old_cols The previous number of columns the board had.
   */
  public SetSizeMove(Model model, int rows, int cols) {
    this.model = model;
    this.rows = rows;
    this.cols = cols;
    this.oldLevel = model.getActiveLevel();
  }

  public boolean execute() {
    if (!isValid()) return false;
    model.setActiveLevel((Level)model.getActiveLevel().clone());
    
    model.getActiveLevel().getBoard().resizeBoard(rows, cols);

    return true;
  }

  public boolean undo() {
    model.setActiveLevel(oldLevel);
    return true;
  }

  public boolean isValid() {
    return rows > 0 && rows <= Board.MAX_SIZE &&
           cols > 0 && cols <= Board.MAX_SIZE;
  }

}
