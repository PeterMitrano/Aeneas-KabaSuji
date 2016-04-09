package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.PlaySelectLevelView;

// @brief Handles a button press on one button in the build select view
public class StartBuildLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  BuildSelectLevelView view;

  public StartEditingLevelController(BuildSelectLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    view.parentView.switchToBuildLevelView();
  }

}
