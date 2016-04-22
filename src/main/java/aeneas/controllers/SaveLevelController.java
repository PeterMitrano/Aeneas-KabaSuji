package aeneas.controllers;

import java.io.File;
import java.io.IOException;

import aeneas.models.Level;
import aeneas.views.MainView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Saves the current level.
 * @author jbkuszmaul
 */
public class SaveLevelController implements EventHandler<MouseEvent> {
  MainView view;
  Level level;

  public SaveLevelController(MainView view, Level level){
    this.view = view;
    this.level = level;
  }

  @Override
  public void handle(MouseEvent event) {
    File saveFile = view.showSaveDialog();
    if (saveFile == null) return;
    try {
      // We retrieve the current level live, because the current
      // level will change over time.
      level.save(saveFile);
    } catch (IOException i) {
      System.out.println("Error occurred in opening file.");
    }
  }

}
