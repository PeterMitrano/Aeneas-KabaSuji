package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.views.MainView;

// @brief Handles a button press on one button in the level select view
public class ViewAboutController implements EventHandler<MouseEvent> {

  String aboutText;
  MainView view;

  public ViewAboutController(MainView view, String aboutText){
    this.aboutText = aboutText;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
