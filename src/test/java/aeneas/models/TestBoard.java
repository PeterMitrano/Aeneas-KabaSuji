package aeneas.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
  
  @Test
  public void testRelease() {
    ArrayList<ReleaseNumber> numbers = new ArrayList<>();
    numbers.add(new ReleaseNumber(0, 0, ReleaseNumber.Color.BLUE, 1));
    numbers.add(new ReleaseNumber(1, 0, ReleaseNumber.Color.RED, 1));
    numbers.add(new ReleaseNumber(2, 0, ReleaseNumber.Color.GREEN, 1));
    ReleaseBoard b = new ReleaseBoard(numbers);
    ReleaseLevel l = new ReleaseLevel(new Bullpen(), b);

    Piece p = new Piece(new Square[] { new Square(0,0) });
    PlacedPiece pp = new PlacedPiece(p, 0, 0);

    assertEquals(0, l.numCoveredNumberSets());
    b.addPiece(pp);
    assertEquals(1, l.numCoveredNumberSets());
  }
}
