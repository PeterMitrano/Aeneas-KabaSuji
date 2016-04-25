package aeneas.controllers;

import org.hamcrest.core.IsInstanceOf;

import aeneas.models.Model;
import aeneas.views.BuildLevelView;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

// TODO: Figure out correct type of Event.
public class UndoRedoController implements EventHandler<KeyEvent> {

  Model model;
  BuildLevelView view;

  public UndoRedoController(BuildLevelView view, Model model){
    this.model = model;
    this.view = view;
  }

  @Override
  public void handle(KeyEvent event) {
    if(event.isControlDown()){
      if(event.getCode().equals(KeyCode.Z))
        undoMove();
      else if(event.getCode().equals(KeyCode.Y))
        redoMove();
    }
  }

  /**
   * Undoes a single move if possible
   */
  public void undoMove(){
    if(model.undoLastMove()){
      view.refreshAll();
    }
  }

  /**
   * redoes a single move if possible
   */
  public void redoMove(){
    if(model.redoLastMove()){
      view.refreshAll();
    }

  }

}
