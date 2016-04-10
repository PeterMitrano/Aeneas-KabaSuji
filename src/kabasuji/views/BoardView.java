package kabasuji.views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import kabasuji.models.Board;
import kabasuji.models.Square;

class BoardView extends Pane {

  static final int SQUARE_SIZE = 40;
  private static final int SPACING = 0;

  SquareView[][] grid = new SquareView[Board.SIZE][Board.SIZE];

  public BoardView(Square squares[][]) {

    this.setPrefWidth(Board.SIZE * (SQUARE_SIZE + SPACING));
    this.setPrefHeight(Board.SIZE * (SQUARE_SIZE + SPACING));

    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        grid[i][j] = new SquareView(squares[i][j], SQUARE_SIZE);
        grid[i][j].setX((SQUARE_SIZE + SPACING) * i);
        grid[i][j].setY((SQUARE_SIZE + SPACING) * j);
        grid[i][j].setFill(Color.GRAY);
        this.getChildren().add(grid[i][j]);
      }
    }
  }
}
