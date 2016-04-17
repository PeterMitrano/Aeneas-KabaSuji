package aeneas.controllers;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import aeneas.models.Model;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ViewHelpController implements EventHandler<MouseEvent> {

  String helpText;
  JFXDialog dialog;
  JFXDialogLayout layout;
  MainView mainView;

  public ViewHelpController(MainView mainView, JFXDialog dialog, JFXDialogLayout layout, String helpText){
    this.helpText = helpText;
    this.mainView = mainView;
    this.dialog = dialog;
    this.layout = layout;
  }

  @Override
  public void handle(MouseEvent event) {
    layout.getHeading().clear();
    layout.getBody().clear();
    layout.setHeading(new Label("Help"));
    layout.setBody(new Label(Model.helpText));
    dialog.show(mainView);
  }

}
