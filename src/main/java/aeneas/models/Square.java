package aeneas.models;

public class Square implements java.io.Serializable {
  int dRow, dCol;

  public Square(int dRow, int dCol) {
    this.dRow = dRow;
    this.dCol = dCol;
  }

  public int getRow() { return dRow; }
  public int getCol() { return dCol; }

  public void setRow(int row) { dRow = row; }
  public void setCol(int col) { dCol = col; }
}
