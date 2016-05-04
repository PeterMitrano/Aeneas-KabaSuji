package aeneas.controllers;
import aeneas.models.Model;
import aeneas.views.BuildLevelView;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Controller for handling all undoing and redoing
 * @author Logan
 * @author Logan
 */
public class UndoRedoController implements EventHandler<KeyEvent> {

  Model model;
  BuildLevelView view;

  /**
   * Constructor.
   * @param view The view to refresh after undoing/redoing a move.
   * @param model The model to update.
   */
  public UndoRedoController(BuildLevelView view, Model model){
    this.view = view;
    this.model = model;
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
    if(model.getActiveLevel().undoLastMove()){
      view.refresh();
    }
  }

  /**
   * redoes a single move if possible
   */
  public void redoMove(){
    if(model.getActiveLevel().redoLastMove()){
      view.refresh();
    }

  }
  

}
