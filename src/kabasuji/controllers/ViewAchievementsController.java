package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.MainView;

// @brief Handles a button press on one button in the level select view
public class ViewAchievementsController implements EventHandler<MouseEvent> {

  Achievement[*] achievements;
  MainView view;

  public ViewAchievementsController(PlaySelectLevelView view, Level levelModel){
    this.achievements = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    view.parentView.switchToViewAchievementsView();
  }

}
