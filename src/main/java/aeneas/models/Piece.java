package aeneas.models;

import javafx.scene.paint.Color;
import javafx.scene.input.DataFormat;

/**
 * A hexonimo or piece used to play KabaSuji.
 * @author Joseph Martin, Garrison
 * @author Logan
 * @author Peter Mitrano
 */
public class Piece implements java.io.Serializable {
  /**
   * An axis to flip a piece around.
   */
  public enum Axis {
    /**
     * Flip across vertical axis.
     */
    VERTICAL,
    /**
     * Flip across horizontal axis.
     */
    HORIZONTAL,
  }

  /**
   * A direction to rotate.
   */
  public enum Dir {
    /**
     * Indicates a clockwise rotation.
     */
    CLOCKWISE,
    /**
     * Indicates a counterclockwise rotation.
     */
    COUNTERCLOCKWISE,
  }

  /**
   * Data format instance used for serializing pieces for drag and drop
   */
  public static final DataFormat dataFormat = new DataFormat("aeneas.Piece");

  Square squares[];
  private int width;
  private int height;
  /**
   * Indicates if this piece is in a bullpen.
   */
  public boolean inBullpen;
  private boolean hint;
  private String color;


  /**
   * Constructor
   * @param squares squares to make the piece from
   */
  public Piece(Square[]squares){
    this(squares, Color.BLUE);
  }

  /**
   * Constructor
   * @param squares
   * @param color
   */
  public Piece(Square[] squares, Color color) {
    this.squares = squares;
    this.color = color.toString();
    width = 0;
    height = 0;
    for (Square s : squares){
      s.setColor(color);
      if(s.getCol() > width)
        width = s.getCol();
      if(s.getRow() > height)
        height = s.getRow();
    }
    width++;
    height++;
    //this should be removed once the actual adding of pieces is implemented
    inBullpen = true;
  }

  /**
   * flips the piece over the specified axis
   * @param axis axis to flip over
   */
  public void flip(Axis axis) {
    for(Square s : squares) {
      switch(axis) {
      case VERTICAL:
        s.setRow(-s.getRow()+getHeight()-1);
        break;
      case HORIZONTAL:
        s.setCol(-s.getCol()+getWidth()-1);
        break;
      }
    }
  }

  /**
   * rotates in  the given direction
   * @param direction direction to rotate
   */
  public void rotate(Dir direction) {
    for(Square s : squares) {
      int row = s.getRow();
      int col = s.getCol();
      switch(direction) {
      case CLOCKWISE:
        s.setCol(-row+getHeight()-1);
        s.setRow(col);
        break;
      case COUNTERCLOCKWISE:
        s.setCol(row);
        s.setRow(-col+getWidth()-1);
        break;
      }
    }
    int temp = height;
    height = width;
    width = temp;
  }

  @Override
  public String toString(){
    String str = "[";
    for (Square s : squares){
      str += s.toString() + ",";
    }
    return str + "]";
  }

  /**
   * Get all the squares in this piece
   * @return an array of squares in this piece
   */
  public Square[] getSquares() {
    return squares;
  }

  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }

  public Color getColor(){ return Color.web(color); }

  /**
   * Set the color of this piece
   * @param c The color to set this piece to.
   */
  public void setColor(Color c) {
    for (Square s : squares){
      s.setColor(c);
    }
   this.color = c.toString();
  }


  @Override
  /**
   * deep copy
   */
  public Piece clone(){
    Square cloneSquares[] = new Square[this.squares.length];
    for (int i=0;i<this.squares.length;i++){
      Square s = this.squares[i];
      cloneSquares[i] = s.clone();
    }

    Piece clone = new Piece(cloneSquares);
    clone.width = this.width;
    clone.height = this.height;
    clone.inBullpen = this.inBullpen;
    return clone;
  }

  /**
   * @return True if this piece is a hint, false otherwise
   */
  public boolean isHint() {
    return hint;
  }

  /**
   * Sets whether or not this piece is a hint.
   * @param hint True to set this piece to be a hint, false otherwise.
   */
  public void setHint(boolean hint) {
    this.hint = hint;
    this.setColor(Color.CORNSILK);
  }
}
