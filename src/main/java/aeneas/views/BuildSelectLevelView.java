package aeneas.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Bullpen;
import aeneas.models.Level;
import aeneas.models.LightningLevel;
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
  private LevelView levelViewToSwitchTo;
  private HashMap<String, LevelView> levelMap = new HashMap<String, LevelView>();

  BuildSelectLevelView(MainView mainView) {
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

    //create default new level
    Level defaultLevel = new LightningLevel(new Bullpen(), 10);
    LevelView defaultLevelView = new LightningView(defaultLevel);
    levelMap.put("DEFAULT", defaultLevelView);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    fileList.setOnMouseClicked((e) -> {
      String path = fileList.getSelectionModel().getSelectedItem().getText();
      
      if (path.equals(createNewLevelLabel.getText())) {
        levelViewToSwitchTo = levelMap.get("DEFAULT");
        mainView.switchToBuildLevelView(levelViewToSwitchTo);
      }
      else {
      levelViewToSwitchTo = levelMap.get(path);

      if (levelViewToSwitchTo == null){
        System.out.println("couldn't find file name " + path);
      }
      }
    });

    editLevel.setOnMouseClicked((e) -> {
      mainView.switchToBuildLevelView(levelViewToSwitchTo);
    });

    openFile.setOnMouseClicked((e) -> {
      File loadFile = mainView.showOpenDialog();
      if (loadFile == null) return;
      try {
        Level newLevel = Level.loadLevel(loadFile);
        this.levelViewToSwitchTo = new LevelView(newLevel);
        String path = loadFile.getAbsolutePath();
        levelMap.put(path, this.levelViewToSwitchTo);
        this.fileList.getItems().add(new Label(path));
      } catch (IOException i) {
        System.out.println("Error occurred opening file.");
      }
    });

    JFXDepthManager.setDepth(fileList, 1);

  }

}
