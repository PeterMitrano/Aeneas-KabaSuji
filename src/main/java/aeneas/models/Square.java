package aeneas.models;

import javafx.scene.paint.Color;

/**
 * 
 * @author Joseph Martin
 * @author Logan Tutt
 */
public class Square implements java.io.Serializable {
  int dRow, dCol;
  ReleaseNumber num;
  Color color;
  
  public Square(int dRow,int dCol,ReleaseNumber num, Color color){
    this.dRow = dRow;
    this.dCol = dCol;
    this.num = num;
    this.color = color;
    
  }
  
  public Square(int dRow, int dCol, Color color){
    this(dRow, dCol,null, color);
  }

  public Square(int dRow, int dCol) {
    this(dRow, dCol,null, Color.GRAY);
  }

  public int getRow() { return dRow; }
  public int getCol() { return dCol; }
  public ReleaseNumber getNum() { return num; }
  public Color getColor() {return color; }

  public void setRow(int row) { dRow = row; }
  public void setCol(int col) { dCol = col; }
  public void setNum(ReleaseNumber num) { this.num = num; }
  public void setColor(Color color) {this.color = color; }
}
