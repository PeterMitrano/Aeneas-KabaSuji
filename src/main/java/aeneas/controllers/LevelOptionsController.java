package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.BuildLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class LevelOptionsController implements EventHandler<MouseEvent> {

  Level levelModel;
  BuildLevelView view;

  public LevelOptionsController(BuildLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
