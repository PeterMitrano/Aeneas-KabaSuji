package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.LevelModel;
import kabasuji.views.PlaySelectLevelView;

// @brief Handles a button press on one button in the level select view
public class SelectLevelController implements EventHandler<MouseEvent> {

  LevelModel levelModel;
  PlaySelectLevelView view;

  public SelectLevelController(PlaySelectLevelView view, LevelModel levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println("enter level " + levelModel.levelNumber);
    view.parentView.switchToPlayLevelView();
  }

}
