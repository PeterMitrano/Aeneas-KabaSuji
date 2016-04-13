package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.PlaySelectLevelView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// @brief Handles a button press on one button in the level select view
public class SelectLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  PlaySelectLevelView view;

  public SelectLevelController(PlaySelectLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println("enter level " + levelModel.levelNumber);
    view.parentView.switchToPlayLevelView();
  }

}
