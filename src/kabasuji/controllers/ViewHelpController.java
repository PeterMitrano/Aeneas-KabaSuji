package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.views.MainView;

public class ViewHelpController implements EventHandler<MouseEvent> {

  String helpText;
  MainView view;

  public ViewHelpController(MainView view, String helpText){
    this.levelModel = levelModel;
    this.helpText = helpText;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
