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
  
  /**
   * Adds the given piece to the board, if valid.
   * @param piece The piece to add to the board.
   * @return true if the piece was added to the board, false otherwise.
   */
  public boolean addPiece(PlacedPiece piece) {
    return false;
  }
  
  /**
   * Removes the given piece from the board, if possible
   * @param piece The piece to be removed
   * @return true If the piece on the board and it was removed, false otherwise.
   */
  public boolean removePiece(PlacedPiece piece) {
    return false;
  }
  
  /**
   * Gets the piece at the specified position (if there is one)
   * @param row The row coordinate
   * @param col The column coordinate
   * @return The piece at the given position if there is one, null otherwise
   */
  public Piece getPieceAtLocation(int row, int col) {
    return null;
  }
  
  /**
   * Test if the given piece would intersect a piece on the board
   * @param piece The piece to test intersection for
   * @return true if the piece intersects another piece on the board, false otherwise.
   */
  public boolean intersects(PlacedPiece piece) {
    return false;
  }
  
  public abstract int getStarsEarned();
}
