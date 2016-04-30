package aeneas.controllers;


import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.views.BuildLevelView;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

// TODO: Figure out correct type of Event.
public class UndoRedoController implements EventHandler<KeyEvent> {

  Level level;
  BuildLevelView view;

  public UndoRedoController(BuildLevelView view, Level level){
    this.level = level;
    this.view = view;
  }

  @Override
  public void handle(KeyEvent event) {
    if(event.isControlDown() && event.getCode().equals(KeyCode.Z)){
      if(event.isShiftDown())
        redoMove();
      else 
        undoMove();
    }
  }

  /**
   * Undoes a single move if possible
   */
  public void undoMove(){
    if(level.undoLastMove()){
      view.refreshAll();
    }
  }

  /**
   * redoes a single move if possible
   */
  public void redoMove(){
    if(level.redoLastMove()){
      view.refreshAll();
    }

  }

}
