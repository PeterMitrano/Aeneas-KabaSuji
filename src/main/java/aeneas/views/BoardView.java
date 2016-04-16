package aeneas.views;

import aeneas.models.Board;

import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

class BoardView extends Pane {

  static final int SQUARE_SIZE = 40;

  SquareView[][] grid = new SquareView[Board.SIZE][Board.SIZE];
  Board board;

  public BoardView(Board board) {
    this.board = board;
    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        grid[i][j] = new SquareView(SQUARE_SIZE);
        grid[i][j].setX(SQUARE_SIZE * i);
        grid[i][j].setY(SQUARE_SIZE * j);
        grid[i][j].setFill(Color.GRAY);
        this.getChildren().add(grid[i][j]);
      }
    }

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
}
