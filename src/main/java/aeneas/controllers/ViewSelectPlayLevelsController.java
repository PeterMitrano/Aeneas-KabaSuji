package aeneas.controllers;

import aeneas.models.Model;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ViewSelectPlayLevelsController implements EventHandler<MouseEvent> {

  Model model;
  MainView view;

  public ViewSelectPlayLevelsController(MainView view, Model model){
    this.model = model;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    view.switchToPlaySelectLevelView();
  }

}
