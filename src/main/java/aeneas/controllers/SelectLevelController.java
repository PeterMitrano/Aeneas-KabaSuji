package aeneas.controllers;

import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles a button press on one button in the play select view.
 * 
 * @author Joseph Martin
 */
public class SelectLevelController implements EventHandler<MouseEvent> {

  Model gameModel;
  Level levelModel;
  MainView view;

  public SelectLevelController(MainView view, Model gameModel, Level levelModel){
    this.levelModel = levelModel;
    this.gameModel = gameModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println("enter level " + levelModel.getLevelNumber());
    if (!gameModel.getMetadata(levelModel).isLocked()) {
      view.switchToPlayLevelView(levelModel);
    }
  }

  public void resetLevel() {
    levelModel.reset();
    System.out.println("Resetting Level");
  }

}
