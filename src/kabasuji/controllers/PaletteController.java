package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.BuildLevelView;

// @brief Handles a button press on one button in the level select view
public class PaletteController implements EventHandler<MouseEvent> {

  Level levelModel;
  BuildLevelView view;

  public PaletteController(BuildLevelView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
