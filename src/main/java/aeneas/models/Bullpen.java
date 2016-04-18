package aeneas.models;

import java.util.ArrayList;

public class Bullpen implements java.io.Serializable {
  ArrayList<Piece> pieces;

  /**
   * Construct a bullpen with an empty list of pieces.
   */
  public Bullpen() {
    this.pieces = new ArrayList<Piece>();
  }

  /**
   * Construct a bullpen with the given list of pieces
   * @param pieces The initial list of pieces for the bullpen to contain.
   */
  public Bullpen(ArrayList<Piece> pieces) {
    this.pieces = pieces;
  }

  /**
   * Adds a piece to he bullpen
   * @param piece the piece to add
   */
  void addPiece(Piece piece) {
    pieces.add(piece);
  }

  /**
   * Removes the given piece from the bullpen, if present.
   * @param piece the piece to remove.
   * @return true if piece was found and removed, false otherwise.
   */
  boolean removePiece(Piece piece) {
    return pieces.remove(piece);
  }
}
