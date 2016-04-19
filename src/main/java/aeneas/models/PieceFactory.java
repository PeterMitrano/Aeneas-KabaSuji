package aeneas.models;

/**
 * A factory to get the hexonimoes based on their number from 0-35.
 * @author Joseph Martin
 */
public class PieceFactory {
  static Piece[] pieceIndex = {
    /* TODO: Fill in pieces here */
  };
  
  public static Piece makePiece(int piece) {
    return pieceIndex[piece];
  }
}
