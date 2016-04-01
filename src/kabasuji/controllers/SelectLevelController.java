package kabasuji.controllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.LevelModel;

// @brief Handles a button press on one button in the level select view
public class SelectLevelController implements EventHandler<MouseEvent> {

  LevelModel levelModel;

  public SelectLevelController(LevelModel levelModel){
    this.levelModel = levelModel;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println("enter level " + levelModel.levelNumber);
  }

}
