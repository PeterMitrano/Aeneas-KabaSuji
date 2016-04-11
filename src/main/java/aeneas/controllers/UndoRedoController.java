package aeneas.controllers;

import aeneas.models.Model;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// TODO: Figure out correct type of Event.
public class UndoRedoController implements EventHandler<MouseEvent> {

  Model model;
  MainView view;

  public UndoRedoController(MainView view, Model model){
    this.model = model;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
