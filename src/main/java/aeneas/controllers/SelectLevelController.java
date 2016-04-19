package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @brief Handles a button press on one button in the play select view
 * 
 * @author Joseph Martin
 */
public class SelectLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  MainView view;

  public SelectLevelController(MainView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println("enter level " + levelModel.levelNumber);
    if (!levelModel.isLocked()) {
      view.switchToPlayLevelView();
      resetLevel();
    }
  }

  public void resetLevel() {
    levelModel.reset();
    System.out.println("Resetting Level");
  }

}
