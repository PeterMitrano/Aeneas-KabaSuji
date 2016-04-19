package aeneas.models;

/**
 * A Subclass of board with functionality specific to lightning mode.
 * @author Joseph Martin
 */
public class LightningBoard extends Board implements java.io.Serializable {
  boolean coveredSquares[][];
  
  public LightningBoard() {
    super();
    
    coveredSquares = new boolean[SIZE][SIZE];
    for(int j = 0; j < SIZE; j++) {
      for(int i = 0; i < SIZE; i++) {
        coveredSquares[j][i] = false;
      }
    }
  }
  
  @Override
  public boolean addPiece(PlacedPiece piece) {
    if(super.addPiece(piece)) {
      // Mark the squares as covered
      for(Square s : piece.getSquares()) {
        coveredSquares[s.getRow()][s.getCol()] = true;
      }
      // Remove the piece
      removePiece(piece);
      return true;
    } else {
      return false;
    }
  }
  
  public int numCoveredSquares() {
    int count = 0;
    
    for(int j = 0; j < SIZE; j++) {
      for(int i = 0; i < SIZE; i++) {
        count += coveredSquares[j][i] ? 1 : 0;
      }
    }
    
    return count;
  }
}
