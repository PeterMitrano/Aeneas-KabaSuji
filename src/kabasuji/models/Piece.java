package kabasuji.models;

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

  public Piece(){
    squares = new Square[6];
    for (int i=0;i<6;i++){
    	squares[i] = new Square();
    }
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
}
