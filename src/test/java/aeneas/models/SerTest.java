package aeneas.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    LightningLevel s = new LightningLevel(new Bullpen(), 10);

    try {
      // TODO: Figure out proper place to write serialized file.
      FileOutputStream fileOut = new FileOutputStream("tmp_level.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(s);
      out.close();
      fileOut.close();
      System.out.println("Serialized data is saved in tmp_level.ser");
    } catch (IOException i) {
      i.printStackTrace();
    }

    Level d = null;
    try {
      FileInputStream fileIn = new FileInputStream("tmp_level.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      d = (Level)in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException i) {
      i.printStackTrace();
      return;
    } catch (ClassNotFoundException c) {
      System.out.println("Level class not found");
      c.printStackTrace();
      return;
    }

    assertTrue(d instanceof LightningLevel);
    assertFalse(d instanceof ReleaseLevel);
    assertFalse(d instanceof PuzzleLevel);

    LightningLevel ll = (LightningLevel)d;

    assertEquals(ll.allowedTime, 10);
  }
}
