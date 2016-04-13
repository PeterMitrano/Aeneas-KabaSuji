package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.PlaySelectLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// Honestly, this may not be worth it; the back button seems fine as is
// and I'm not sure whether we will ever need to actually add anything
// to the back button (but if people think that we will, then we can
// actually use this class).
public class ReturnToMainMenuController implements EventHandler<MouseEvent> {

  Level levelModel;
  PlaySelectLevelView view;

  public ReturnToMainMenuController(PlaySelectLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    view.parentView.switchToWelcomeView();
  }

}
