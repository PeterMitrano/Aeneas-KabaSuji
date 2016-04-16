package aeneas.views;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.controllers.StartBuildLevelController;
import aeneas.models.Model;
import aeneas.models.Level;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

public class BuildSelectLevelView extends BorderPane implements Initializable {

  @FXML
  private Label createNewLevelLabel;
  @FXML
  private JFXListView<Label> fileList;

  @FXML
  private JFXButton openFile;

  @FXML
  private JFXButton editLevel;

  private Model model;

  private MainView parentView;

  BuildSelectLevelView(MainView parentView, Model model) {
    this.model = model;
    this.parentView = parentView;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("BuildSelectLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    fileList.setOnMouseClicked((e) -> {
      System.out.println("selected " + fileList.getSelectionModel().getSelectedItem());
    });

    editLevel.setOnMouseClicked(new StartBuildLevelController(parentView, null));

    openFile.setOnMouseClicked((e) -> {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Existing Level");
      File loadFile = fileChooser.showOpenDialog(parentView.stage);
      if (loadFile == null) return;
      try {
        Level loadLevel = Level.loadLevel(loadFile);
        parentView.getBuildLevelView().levelModel = loadLevel;
      } catch (IOException i) {
        System.out.println("Error occurred opening file.");
      }
    });

    createNewLevelLabel.setOnMouseClicked((e) -> {
      parentView.switchToBuildLevelView();
    });

    JFXDepthManager.setDepth(fileList, 1);

  }

}
