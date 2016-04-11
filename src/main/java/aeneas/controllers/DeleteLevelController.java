package aeneas.controllers;

import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.views.BuildSelectLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DeleteLevelController implements EventHandler<MouseEvent> {
  Model model;
  BuildSelectLevelView view;
  Level deleteLevel;

  public DeleteLevelController(BuildSelectLevelView view, Model model, Level deleteLevel){
    this.model = model;
    this.view = view;
    this.deleteLevel = deleteLevel;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
