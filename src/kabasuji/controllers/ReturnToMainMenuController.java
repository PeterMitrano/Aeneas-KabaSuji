package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.PlaySelectLevelView;

// @brief Handles a button press on one button in the level select view
public class ReturnToMainMenuController implements EventHandler<MouseEvent> {

  Level levelModel;
  PlaySelectLevelView view;

  public ReturnToMainMenuController(PlaySelectLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    view.parentView.switchToMainView();
  }

}
