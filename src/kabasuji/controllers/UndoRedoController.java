package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.MainView;

// TODO: Figure out correct type of Event.
public class UndoRedoController implements EventHandler<MouseEvent> {

  Model model;
  MainView view;

  public UndoRedoController(MainView view, Model model){
    this.model = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
