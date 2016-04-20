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

  public Piece(Square[] squares) {
    this.squares = squares;
  }

  public void flip(Axis axis) {
    for(Square s : squares) {
      switch(axis) {
      case VERTICAL:
        s.setCol(-s.getCol());
        break;
      case HORIZONTAL:
        s.setRow(-s.getRow());
      }
    }
  }

  public void rotate(Dir direction) {
    for(Square s : squares) {
      switch(direction) {
      case CLOCKWISE:
        s.setRow(-s.getCol());
        s.setCol(s.getRow());
        break;
      case COUNTERCLOCKWISE:
        s.setRow(s.getCol());
        s.setCol(-s.getRow());
        break;
      }
    }
  }

  public Square[] getSquares() {
    return squares;
  }
}
