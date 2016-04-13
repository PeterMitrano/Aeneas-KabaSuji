package aeneas.controllers;

import aeneas.models.Model;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ViewSelectBuildLevelsController implements EventHandler<MouseEvent> {

  Model model;
  MainView view;

  public ViewSelectBuildLevelsController(MainView view, Model model){
    this.model = model;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    view.switchToBuildSelectLevelView();
  }

}
