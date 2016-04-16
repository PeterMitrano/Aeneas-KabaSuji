package aeneas.controllers;

import aeneas.models.Level;

import java.io.File;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// Not sure what sort of event this ends up taking.
public class SaveLevelController implements EventHandler<MouseEvent> {

  Level levelModel;
  Stage mainStage;

  public SaveLevelController(Stage mainStage, Level levelModel){
    this.levelModel = levelModel;
    this.mainStage = mainStage;
  }

  @Override
  public void handle(MouseEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save Level");
    File saveFile = fileChooser.showSaveDialog(mainStage);
    if (saveFile == null) return;
    try {
      levelModel.save(saveFile);
    } catch (IOException i) {
      System.out.println("Error occurred in opening file.");
    }
  }

}
