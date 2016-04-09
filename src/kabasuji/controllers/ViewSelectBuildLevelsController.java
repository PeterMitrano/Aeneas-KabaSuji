package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Model;
import kabasuji.views.MainView;

public class ViewSelectBuildLevelsController implements EventHandler<MouseEvent> {

  Model model;
  MainView view;

  public ViewSelectBuildLevelsController(MainView view, Model model){
    this.model = model;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
