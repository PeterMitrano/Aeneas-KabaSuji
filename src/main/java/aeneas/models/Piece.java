package aeneas.models;

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


  public Piece(Square[] squares) {
    this.squares = squares;
    width = 0;
    height = 0;
    for (Square s : squares){
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
}
