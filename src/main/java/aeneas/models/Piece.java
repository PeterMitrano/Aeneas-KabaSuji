package aeneas.models;

public class Piece {
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
    
  }
  
  public Square[] getSquares() { 
    return squares; 
  }
}
