package kabasuji.models;

public class PlacedPiece {
  Piece piece;
  int row, col;
  
  PlacedPiece(Piece piece, int row, int col) {
    this.piece = piece;
    this.row = row;
    this.col = col;
  }
}
