package kabasuji.models;

public class PieceFactory {
  static Piece[] pieceIndex = {
    /* TODO: Fill in pieces here */
  };
  
  public static Piece makePiece(int piece) {
    return pieceIndex[piece];
  }
}
