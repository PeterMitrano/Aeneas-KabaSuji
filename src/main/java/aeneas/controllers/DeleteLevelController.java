package aeneas.controllers;

import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.views.BuildSelectLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Controller for deleting levels
 * @author Logan
 *
 */
public class DeleteLevelController implements EventHandler<MouseEvent> {
  Model model;
  BuildSelectLevelView view;
  Level deleteLevel;

  /**
   * Constructor
   * @param view
   * @param model
   * @param deleteLevel
   */
  public DeleteLevelController(BuildSelectLevelView view, Model model, Level deleteLevel){
    this.model = model;
    this.view = view;
    this.deleteLevel = deleteLevel;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
