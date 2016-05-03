package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.PlayLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Controller for ending a level
 * @author Logan
 *
 */
public class EndLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  PlayLevelView view;

  /**
   * Constructor
   * @param view
   * @param levelModel
   */
  public EndLevelController(PlayLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
