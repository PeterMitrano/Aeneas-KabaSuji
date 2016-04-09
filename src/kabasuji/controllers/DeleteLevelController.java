package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Model;
import kabasuji.models.Level;
import kabasuji.views.BuildSelectLevelView;

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
