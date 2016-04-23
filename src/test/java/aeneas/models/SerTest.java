package aeneas.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testLevel() {
    LightningLevel s = new LightningLevel(new Bullpen(), 10);
    File file = new File("test_level.ksb");
    Piece piece = new Piece(new Square[] {
        new Square(0,0),
        new Square(1,0),
        new Square(2,0),
        new Square(3,0),
        new Square(4,0),
        new Square(5,0),
    });
    s.getBullpen().addPiece(piece);

    try {
      s.save(file);
    } catch (IOException i) {
      i.printStackTrace();
      fail("Exception occurred on saving file.");
    }

    Level d = null;
    try {
      d = Level.loadLevel(file);
    } catch (IOException i) {
      i.printStackTrace();
      fail("Exception occurred on loading file.");
    }

    assertTrue(d instanceof LightningLevel);
    assertFalse(d instanceof ReleaseLevel);
    assertFalse(d instanceof PuzzleLevel);

    LightningLevel ll = (LightningLevel)d;

    assertEquals(ll.allowedTime, 10);
    assertEquals(1, ll.getBullpen().getPieces().size());

    Piece p = ll.getPieces().get(0);
    for(int i = 0; i < 6; i++) {
      assertEquals(0, p.getSquares()[i].getCol());
      assertEquals(i, p.getSquares()[i].getRow());
    }
  }
  
  @Test
  public void testMetadata() {
    Model m = new Model();
    m.getMetadata(m.getLevel(2)).setLocked(false);
    assertFalse(m.getMetadata(m.getLevel(2)).isLocked());
    File file = new File("test_metadata.dat");
    
    try {
      m.saveLevelMetadata(file);
    } catch (IOException e) {
      e.printStackTrace();
      fail("Failed to write file");
    }

    m = new Model();
    try {
      m.loadLevelMetadata(file);
    } catch (IOException e) {
      e.printStackTrace();
      fail("Failed to read file");
    }
    
    assertFalse(m.getMetadata(m.getLevel(2)).isLocked());
  }
}
