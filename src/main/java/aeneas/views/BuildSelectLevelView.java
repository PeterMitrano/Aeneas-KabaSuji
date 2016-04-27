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
import aeneas.models.Bullpen.BullpenLogic;
import aeneas.models.Level;
import aeneas.models.PuzzleLevel;

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
  private LevelWidgetView levelViewToSwitchTo;
  private HashMap<String, LevelWidgetView> levelMap = new HashMap<String, LevelWidgetView>();

  BuildSelectLevelView(MainView mainView) {
    this.mainView = mainView;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("BuildSelectLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private LevelWidgetView createDefaultLevelView() {
    Bullpen defaultBullpen  = new Bullpen(BullpenLogic.editorLogic());
    PuzzleLevel defaultLevel = new PuzzleLevel(defaultBullpen);
    return new PuzzleWidgetView(defaultLevel);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    fileList.setOnMouseClicked((e) -> {
      Label l = fileList.getSelectionModel().getSelectedItem();

      if (l != null) {
        String path = l.getText();

        if (path.equals(createNewLevelLabel.getText())) {
          levelViewToSwitchTo = createDefaultLevelView();
          mainView.switchToBuildLevelView(levelViewToSwitchTo);
        } else {
          levelViewToSwitchTo = levelMap.get(path);

          if (levelViewToSwitchTo == null) {
            System.out.println("couldn't find file name " + path);
          }
        }
      }
    });

    editLevel.setOnMouseClicked((e) -> {
      mainView.switchToBuildLevelView(levelViewToSwitchTo);
    });

    openFile.setOnMouseClicked((e) -> {
      File loadFile = mainView.showOpenDialog();
      if (loadFile == null)
        return;
      try {
        Level newLevel = Level.loadLevel(loadFile);
        this.levelViewToSwitchTo = newLevel.makeCorrespondingView();
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
