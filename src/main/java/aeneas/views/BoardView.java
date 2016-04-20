package aeneas.views;


import aeneas.models.Board;
import aeneas.models.PlacedPiece;
import aeneas.models.ReleaseNumber;
import aeneas.models.Square;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


/**
 * View class to display a board
 * @author Logan Tutt
 *
 */
public class BoardView extends GridPane {

  /** Specifies how many pixels the squares of a piece on the board will be */
  static final int SQUARE_SIZE = 40;

  //StackPane[][] grid = new StackPane[Board.SIZE][Board.SIZE];
  SquareView[][] grid = new SquareView[Board.SIZE][Board.SIZE];
  Board board;

  /**
   * Initialized the board with grey squares
   * @param board the board model object.
   * Eventually this will model object will describe which squares are active
   */
  public BoardView(Board board) {
    this.board = board;
    refresh();

    // This handle the drop of a piece on the board
    this.setOnDragDropped((DragEvent event) -> {
      Dragboard db = event.getDragboard();
      boolean success = false;

      // when we create a drag event we gave it a string
      // so check that this is present
      if (db.hasString()) {

        // Get an item ID here, which was stored when the drag started.
        // eventually we will use something better than a string
        String pieceToString = db.getString();
        System.out.println("Adding " + pieceToString);

      }

      //this might change we we actually implement it,
      //such as if they drop it on a square that doesn't exist
      event.setDropCompleted(success);
      event.consume();
    });
  }

  /**
   * Refreshes the view to match the current state of the board
   */
  public void refresh(){
    Square[][] squares = board.getSquares();
    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {         
        grid[i][j] = new SquareView(SQUARE_SIZE, squares[i][j]);
        this.add(grid[i][j], i, j);
      }
    }
  }
}
