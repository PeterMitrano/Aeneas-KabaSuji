package aeneas.controllers;

import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ViewHelpController implements EventHandler<MouseEvent> {

  String helpText;
  MainView view;

  public ViewHelpController(MainView view, String helpText){
    this.helpText = helpText;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println(helpText);
  }

}
