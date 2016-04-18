package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.MainView;

import java.io.File;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// Not sure what sort of event this ends up taking.
public class SaveLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  MainView view;

  public SaveLevelController(MainView view, Level levelModel){
    this.levelModel = levelModel;
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    File saveFile = view.showSaveDialog();
    if (saveFile == null) return;
    try {
      levelModel.save(saveFile);
    } catch (IOException i) {
      System.out.println("Error occurred in opening file.");
    }
  }

}
