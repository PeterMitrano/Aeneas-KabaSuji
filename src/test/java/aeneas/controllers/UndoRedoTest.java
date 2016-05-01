package aeneas.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aeneas.models.Bullpen;
import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.models.PuzzleLevel;
import aeneas.models.ReleaseLevel;
import aeneas.views.BuildLevelView;
import aeneas.models.Bullpen.BullpenLogic;

public class UndoRedoTest {

  Model model;

  @Before
  public void setUp() throws Exception {
    Level level = new PuzzleLevel(new Bullpen(BullpenLogic.editorLogic()));
    model = new Model();
    model.setActiveLevel(level);
  }

  @After
  public void tearDown() throws Exception {
  }
  
  
  @Test
  public void toggleTileTest() {
    IMove move = new ToggleTileMove(model.getActiveLevel(), 3, 3);
    assertTrue(move.execute());
    
    assertFalse(model.getActiveLevel().getBoard().getSquares()[3][3]);
    
    move.undo();
    
    assertTrue(model.getActiveLevel().getBoard().getSquares()[3][3]);
    
  }
  
  @Test
  public void changeLevelTypeTest(){
    ReleaseLevel l = new ReleaseLevel(model.getActiveLevel());
    IMove move = new ChangeLevelTypeMove(model,l);
    assertTrue(move.execute());
    
    assertTrue(model.getActiveLevel() instanceof ReleaseLevel);
    
    move.undo();
    
    assertTrue(model.getActiveLevel() instanceof PuzzleLevel);
  }

}
