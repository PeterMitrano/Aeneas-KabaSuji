package kabasuji.models;

public class Piece {
  public int row, col;
  public Square squares[];

  public Piece(int row, int col){
	this();
    this.row = row;
    this.col = col;
  }

  public Piece(){
    squares = new Square[6];
    for (int i=0;i<6;i++){
    	squares[i] = new Square();
    }
  }
}
