package aeneas.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Bullpen;
import aeneas.models.Bullpen.BullpenLogic;
import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.models.PuzzleLevel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author Joseph Martin
 */
public class BuildSelectLevelView extends BorderPane implements Initializable, RefreshListener {

  @FXML
  private Label createNewLevelLabel;

  @FXML
  private JFXListView<Label> fileList;

  @FXML
  private JFXButton editLevel;

  private MainView mainView;
  private Level levelToSwitchTo;
  private Model model;

  BuildSelectLevelView(MainView mainView, Model model) {
    this.mainView = mainView;
    this.model = model;
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
    Bullpen defaultBullpen  = new Bullpen(BullpenLogic.puzzleLogic());
    PuzzleLevel defaultLevel = new PuzzleLevel(defaultBullpen);
    return new PuzzleWidgetView(defaultLevel, mainView.getModel());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    fileList.setOnMouseClicked((e) -> {
      Label l = fileList.getSelectionModel().getSelectedItem();

      if (l != null) {
        String text = l.getText();

        if (text.equals(createNewLevelLabel.getText())) {
          levelToSwitchTo = createDefaultLevelView().getDefaultLevelModel();
          levelToSwitchTo.getBullpen().setLogic(BullpenLogic.editorLogic());
          mainView.switchToBuildLevelView(levelToSwitchTo);
        } else {
          levelToSwitchTo = model.getLevel(Integer.parseInt(text));

          if (levelToSwitchTo == null) {
            System.out.println("couldn't find file level " + text);
          }
        }
      }
    });

    editLevel.setOnMouseClicked((e) -> {
      mainView.switchToBuildLevelView(levelToSwitchTo);
    });

    JFXDepthManager.setDepth(fileList, 1);

    refresh();
  }

  public void refresh() {
    fileList.getItems().clear();
    fileList.getItems().add(createNewLevelLabel);

    model.getLevelIndex().reindex();
    
    for(Level l : model.getLevels()) {
      fileList.getItems().add(new Label(l.getLevelNumber()+""));
    }
  }
}
