package aeneas.views;

import aeneas.models.Board;

import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
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

    this.setOnDragDropped((DragEvent event) -> {
      Dragboard db = event.getDragboard();
      boolean success = false;

      // If this is a meaningful drop...
      if (db.hasString()) {

        // Get an item ID here, which was stored when the drag started.
        String pieceToString = db.getString();
        System.out.println("Adding " + pieceToString);

      }
      event.setDropCompleted(success);
      event.consume();
    });

    this.setOnDragOver((DragEvent event) -> {
        event.acceptTransferModes(TransferMode.MOVE);
        event.consume();
    });

    this.setOnMouseClicked((e) -> {
      System.out.println("click");
    });
  }
}
