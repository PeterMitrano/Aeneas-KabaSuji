package main.java.views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.java.models.Board;
import main.java.models.Square;

class BoardView extends Pane {

  static final int SQUARE_SIZE = 45;
  
  SquareView[][] grid = new SquareView[Board.SIZE][Board.SIZE];

  public BoardView(Square squares[][]) {
    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        grid[i][j] = new SquareView(squares[i][j], SQUARE_SIZE);
        grid[i][j].setX(Square.SIZE * i);
        grid[i][j].setY(Square.SIZE * j);
        grid[i][j].setFill(Color.GRAY);
        this.getChildren().add(grid[i][j]);
      }
    }
  }
}