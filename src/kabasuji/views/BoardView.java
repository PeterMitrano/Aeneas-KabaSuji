package kabasuji.views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import kabasuji.models.Board;

class BoardView extends Pane {

  PieceView[][] grid = new PieceView[Board.SIZE][Board.SIZE];
  private Board boardModel;

  public BoardView(Board boardModel) {
    this.boardModel = boardModel;
    for (int i=0;i<Board.SIZE;i++){
      for (int j=0;j<Board.SIZE;j++){
        grid[i][j] = new PieceView(boardModel.grid[i][j]);
        this.getChildren().add(grid[i][j]);
      }
    }
  }
}
