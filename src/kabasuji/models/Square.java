package kabasuji.models;

public class Square {
  public int dRow, dCol;
  public static final int SIZE = 30; // in pixels

  public Square(int dRow, int dCol) {
    this.dRow = dRow;
    this.dCol = dCol;
  }

  public Square() {
  }
}
