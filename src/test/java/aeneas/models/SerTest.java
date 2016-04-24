package aeneas.models;

import static org.junit.Assert.*;

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
  public void test() {
    LightningLevel s = new LightningLevel(new Bullpen(BullpenLogic.lightningLogic()), 10);
    File file = new File("temp_sevel.ksb");

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
