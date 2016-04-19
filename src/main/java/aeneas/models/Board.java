package aeneas.models;

import java.util.ArrayList;

/**
 * Represents a board (which keeps track of its pieces, hints, and the shape of the board).
 * 
 * @author Joseph Martin
 */
public abstract class Board implements java.io.Serializable {

  public static final int SIZE = 12;

  boolean[][] squares = new boolean[SIZE][SIZE];
  ArrayList<PlacedPiece> pieces;
  ArrayList<PlacedPiece> hints;

  public Board() {
    pieces = new ArrayList<>();
    hints = new ArrayList<>();
    for (int i=0;i<SIZE;i++){
      for (int j=0;j<SIZE;j++){
        squares[i][j] = true;
      }
    }
  }
  
  /**
   * Count the number of valid squares on this board
   * @return The number of valid squares.
   */
  int numValidSquares() {
    int count = 0;
    for(int j = 0; j < squares.length; j++) {
      for(int i = 0; i < squares[j].length; i++) {
         count += squares[j][i] ? 1 : 0;
      }
    }
    return count;
  }

  /**
   * Check if a square on the board is valid.
   * If the row or col is < 0 or > 12, the square is invalid,
   * otherwise check if the square is valid in the squares array.
   * @return True if the square is valid, false otherwise.
   */
  boolean locationValid(Square s) {
    int row = s.getRow();
    int col = s.getCol();
    if(row >= 0 && row < squares.length && col >= 0 && col < squares[row].length) {
      return squares[row][col];
    } else {
      return false;
    }
  }

  /**
   * Adds the given piece to the board, if valid.
   * @param piece The piece to add to the board.
   * @return true if the piece was added to the board, false otherwise.
   */
  public boolean addPiece(PlacedPiece piece) {
    // If any of the squares of the piece are at an invalid location,
    // piece placement not valid
    for(Square s : piece.getSquares()) {
      if(!locationValid(s)) return false;
    }
    // If the piece overlaps an existing piece, placement not valid
    if(intersects(piece)) return false;
    // Otherwise placement is valid
    pieces.add(piece);
    return true;
  }

  /**
   * Removes the given piece from the board, if possible
   * @param piece The piece to be removed
   * @return true If the piece on the board and it was removed, false otherwise.
   */
  public boolean removePiece(PlacedPiece piece) {
    return pieces.remove(piece);
  }

  /**
   * Gets the piece at the specified position (if there is one)
   * @param row The row coordinate
   * @param col The column coordinate
   * @return The piece at the given position if there is one, null otherwise
   */
  public PlacedPiece getPieceAtLocation(int row, int col) {
    for(PlacedPiece p : pieces) {
      if(p.intersects(row, col)) {
        return p;
      }
    }

    return null;
  }

  /**
   * Test if the given piece would intersect a piece on the board
   * @param piece The piece to test intersection for
   * @return true if the piece intersects another piece on the board, false otherwise.
   */
  public boolean intersects(PlacedPiece piece) {
    for(PlacedPiece p : pieces) {
      if(piece.intersects(p)) {
        return true;
      }
    }

    return false;
  }
}
