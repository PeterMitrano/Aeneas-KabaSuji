package aeneas.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    Board b = new PuzzleBoard();
    Piece p = new Piece(new Square[] { new Square(0,0) });
    PlacedPiece pp = new PlacedPiece(p, 0, 0);
    boolean success = b.addPiece(pp);
    assertTrue(success);
    assertEquals(b.numValidSquares(), 144);
    assertEquals(b.pieces.size(), 1);
    assertTrue(b.intersects(pp));
    
    assertEquals(b.getPieceAtLocation(0, 0), pp);
  }
  
  @Test
  public void testLightning() {
    LightningBoard b = new LightningBoard();
    Piece p = new Piece(new Square[] { new Square(0,0) });
    PlacedPiece pp = new PlacedPiece(p, 0, 0);
    boolean success = b.addPiece(pp);
    assertTrue(success);
    assertEquals(b.numValidSquares(), 144);
    assertEquals(b.numCoveredSquares(), 1);
    assertEquals(b.pieces.size(), 0);
    assertFalse(b.intersects(pp));
  }
}
