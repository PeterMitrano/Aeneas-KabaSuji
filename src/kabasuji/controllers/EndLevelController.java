package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.PlayLevelView;

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
