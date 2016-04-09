package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.PlaySelectLevelView;

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
    System.out.println("enter level " + levelModel.levelNumber);
    view.parentView.switchToPlayLevelView();
  }

}
