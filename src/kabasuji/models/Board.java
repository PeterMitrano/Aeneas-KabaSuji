package kabasuji.models;

import java.util.ArrayList;

public abstract class Board {

  public static final int SIZE = 12;

  boolean[][] squares = new boolean[SIZE][SIZE];
  ArrayList<PlacedPiece> pieces;
  ArrayList<PlacedPiece> hints;

  public Board() {
    for (int i=0;i<SIZE;i++){
      for (int j=0;j<SIZE;j++){
        squares[i][j] = true;
      }
    }
  }
  
  public boolean addPiece(PlacedPiece piece) {
    return false;
  }
  
  public boolean removePiece(PlacedPiece piece) {
    return false;
  }
  
  public Piece getPieceAtLocation(int row, int col) {
    return null;
  }
  
  public boolean intersects(PlacedPiece piece) {
    return false;
  }
  
  public abstract int getStarsEarned();
}
