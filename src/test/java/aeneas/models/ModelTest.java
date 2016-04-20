package aeneas.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aeneas.models.Bullpen.BullpenLogic;

public class ModelTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    Model m = new Model();
    assertTrue("level count", m.levels.size() > 15);
  }

  @Test
  public void testStars() {
    Model m = new Model();
    Level l = new PuzzleLevel(new Bullpen(BullpenLogic.puzzleLogic()));
    assertEquals(m.getStarsForLevel(l), 0);
    m.setActiveLevel(l);
    m.updateStats();
    assertEquals(m.getStarsForLevel(l), 0);
  }
}
