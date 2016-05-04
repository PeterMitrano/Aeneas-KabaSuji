package aeneas.models;

import javafx.scene.input.DataFormat;
import javafx.scene.paint.Color;

/**
 * A number on a release board
 *
 * @author Joseph Martin
 * @author Logan
 */
public class ReleaseNumber implements java.io.Serializable {
  /**
   * Data format spec for release number
   */
  public static final DataFormat dataFormat = new DataFormat("aeneas.models.ReleaseNumber");

  /** row coordinate */
  int row;
  /** Column coordinate */
  int col;
  /** Number color */
  private String color;
  /** Value of this number */
  int val;

  /**
   * Construct a new release number.
   * @param row The row where this release number is located.
   * @param col The column where this release number is located.
   * @param color The color of this release number.
   * @param val The number to display
   */
  public ReleaseNumber(int row, int col, Color color, int val){
    this.row = row;
    this.col = col;
    this.color = color.toString();
    this.val = val;
  }

  public int getRow() { return row; }
  public int getCol() { return col; }
  public Color getColor() { return Color.web(color); }
  public int getValue() { return val; }


  public void setRow(int row) { this.row = row; }
  public void setCol(int col) { this.col = col; }
  public void setColor(Color color) { this.color = color.toString(); }
  public void setValue(int val) { this.val = val; }

  @Override
  public Object clone() {
    return new ReleaseNumber(this.row, this.col, Color.web(this.color), this.val);
  }
}
