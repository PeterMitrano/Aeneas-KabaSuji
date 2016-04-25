package aeneas.models;

import javafx.scene.paint.Color;

/**
 *
 * @author Joseph Martin
 */
public class Piece implements java.io.Serializable {
  public enum Axis {
    VERTICAL,
    HORIZONTAL,
  }

  public enum Dir {
    CLOCKWISE,
    COUNTERCLOCKWISE,
  }

  Square squares[];
  private int width;
  private int height;
  public boolean inBullpen;
  private Color color;


  public Piece(Square[]squares){
    this(squares, Color.BLUE);
  }

  public Piece(Square[] squares, Color color) {
    this.squares = squares;
    this.color = color;
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

  public void flip(Axis axis) {
    for(Square s : squares) {
      switch(axis) {
      case VERTICAL:
        s.setCol(-s.getCol()+getWidth()-1);
        break;
      case HORIZONTAL:
        s.setRow(-s.getRow()+getHeight()-1);
        break;
      }
    }
  }

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

  public Square[] getSquares() {
    return squares;
  }

  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }
  <<<<<<< HEAD

  public Color getColor(){ return color;}
  =======

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
  >>>>>>> f336ea3bd29e59f1fe4b9ac1bd9f43266a6b831c
}
