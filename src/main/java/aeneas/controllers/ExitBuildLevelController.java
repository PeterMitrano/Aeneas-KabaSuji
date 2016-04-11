package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.BuildLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// @brief Handles a button press on one button in the level select view
public class ExitBuildLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  BuildLevelView view;

  public ExitBuildLevelController(BuildLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
