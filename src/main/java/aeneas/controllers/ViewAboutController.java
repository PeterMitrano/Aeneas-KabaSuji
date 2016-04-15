package aeneas.controllers;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import aeneas.models.Model;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

// @brief Handles displaying help text on button text.
public class ViewAboutController implements EventHandler<MouseEvent> {

  String aboutText;
  JFXDialog dialog;
  JFXDialogLayout layout;
  MainView mainView;

  public ViewAboutController(MainView mainView, JFXDialog dialog, JFXDialogLayout layout, String aboutText){
    this.aboutText = aboutText;
    this.mainView = mainView;
    this.dialog = dialog;
    this.layout = layout;
  }

  @Override
  public void handle(MouseEvent event) {
    layout.getHeading().clear();
    layout.getBody().clear();
    layout.setHeading(new Label("About"));
    layout.setBody(new Label(Model.aboutText));
    dialog.show(mainView);
  }

}
