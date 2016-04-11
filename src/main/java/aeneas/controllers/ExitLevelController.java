package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.PlayLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ExitLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  PlayLevelView view;

  public ExitLevelController(PlayLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
