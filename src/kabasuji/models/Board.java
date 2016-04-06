package kabasuji.models;

public class Board {

  public static final int SIZE = 12;

  public Piece[][] grid = new Piece[SIZE][SIZE];

  public Board() {
    for (int i=0;i<SIZE;i++){
      for (int j=0;j<SIZE;j++){
        grid[i][j] = new Piece(i,j);
      }
    }
  }
}
