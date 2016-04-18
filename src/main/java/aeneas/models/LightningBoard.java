package aeneas.models;

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
  
  int numCoveredSquares() {
    int count = 0;
    
    for(int j = 0; j < SIZE; j++) {
      for(int i = 0; i < SIZE; i++) {
        count += coveredSquares[j][i] ? 1 : 0;
      }
    }
    
    return count;
  }
}
