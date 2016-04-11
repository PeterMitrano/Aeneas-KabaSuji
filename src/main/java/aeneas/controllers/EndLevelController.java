package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.PlayLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// @brief Handles the user ending a level.
public class EndLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  PlayLevelView view;

  public EndLevelController(PlayLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
