package aeneas.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Level;
import aeneas.models.Model;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class BuildSelectLevelView extends BorderPane implements Initializable {

  @FXML
  private Label createNewLevelLabel;
  @FXML
  private JFXListView<Label> fileList;

  @FXML
  private JFXButton openFile;

  @FXML
  private JFXButton editLevel;


  private MainView mainView;

  BuildSelectLevelView(MainView mainView, Model model) {
    this.mainView = mainView;
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

    editLevel.setOnMouseClicked((e) -> {
      mainView.switchToBuildLevelView();
    });

    openFile.setOnMouseClicked((e) -> {
      File loadFile = mainView.showOpenDialog();
      if (loadFile == null) return;
      try {
        Level loadLevel = Level.loadLevel(loadFile);
        mainView.getBuildLevelView().levelModel = loadLevel;
      } catch (IOException i) {
        System.out.println("Error occurred opening file.");
      }
    });

    createNewLevelLabel.setOnMouseClicked((e) -> {
      mainView.switchToBuildLevelView();
    });

    JFXDepthManager.setDepth(fileList, 1);

  }

}
