package aeneas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aeneas.models.Bullpen.BullpenLogic;

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
  public void testPuzzleLevelSerialize() {
    PuzzleLevel s = new PuzzleLevel(new Bullpen(), false);
    s.setAllowedMoves(10);
    File file = new File("build/puzzle.ksb");

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

    assertFalse(d instanceof LightningLevel);
    assertFalse(d instanceof ReleaseLevel);
    assertTrue(d instanceof PuzzleLevel);

    PuzzleLevel pl = (PuzzleLevel)d;

    assertEquals(pl.getAllowedMoves(), 10);
  }

  @Test
  public void testLighteningSerialize() {
    LightningLevel s = new LightningLevel(new Bullpen(), 10);
    File file = new File("build/lightening.ksb");

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
  }
}
