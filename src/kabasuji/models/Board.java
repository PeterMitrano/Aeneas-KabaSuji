package kabasuji.models;

public class Board {

  public static final int SIZE = 12;

  public Square[][] squares = new Square[SIZE][SIZE];

  public Board() {
    for (int i=0;i<SIZE;i++){
      for (int j=0;j<SIZE;j++){
        squares[i][j] = new Square();
      }
    }
  }
}
