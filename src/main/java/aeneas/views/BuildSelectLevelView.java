package aeneas.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Stream;

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

public class BuildSelectLevelView extends BorderPane implements Initializable, RefreshListener {

  @FXML
  private Label createNewLevelLabel;

  @FXML
  private JFXListView<Label> fileList;

  @FXML
  private JFXButton openFile;

  @FXML
  private JFXButton editLevel;

  private MainView mainView;
  private Level levelToSwitchTo;
  private HashMap<String, Level> levelMap = new HashMap<>();

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
    Bullpen defaultBullpen  = new Bullpen(BullpenLogic.puzzleLogic());
    PuzzleLevel defaultLevel = new PuzzleLevel(defaultBullpen);
    return new PuzzleWidgetView(defaultLevel, mainView.getModel());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    fileList.setOnMouseClicked((e) -> {
      Label l = fileList.getSelectionModel().getSelectedItem();

      if (l != null) {
        String path = l.getText();

        if (path.equals(createNewLevelLabel.getText())) {
          levelToSwitchTo = createDefaultLevelView().getDefaultLevelModel();
          levelToSwitchTo.getBullpen().setLogic(BullpenLogic.editorLogic());
          mainView.switchToBuildLevelView(levelToSwitchTo);
        } else {
          levelToSwitchTo = levelMap.get(path);

          if (levelToSwitchTo == null) {
            System.out.println("couldn't find file name " + path);
          }
        }
      }
    });

    editLevel.setOnMouseClicked((e) -> {
      mainView.switchToBuildLevelView(levelToSwitchTo);
    });

    openFile.setOnMouseClicked((e) -> {
      File loadFile = mainView.showOpenDialog();
      if (loadFile == null)
        return;
      try {
        levelToSwitchTo = Level.loadLevel(loadFile);
        String path = loadFile.getAbsolutePath();
        levelMap.put(path, levelToSwitchTo);
        refresh();
      } catch (IOException i) {
        i.printStackTrace(System.out);
        System.out.println("Error occurred opening file.");
      }
    });

    JFXDepthManager.setDepth(fileList, 1);

    refresh();
  }

  public void refresh() {
    fileList.getItems().clear();
    
    fileList.getItems().add(createNewLevelLabel);
    Path defaultLevelPath = Paths.get(System.getenv("HOME"), ".aeneas-kabasuji");
    try {
      Stream<Path> files = Files.list(defaultLevelPath).filter(file -> file.getFileName().toString().endsWith(".kbs"));
      files.forEach((file) -> {
        ObjectInputStream ois = null;
        try {
          ois = new ObjectInputStream(new FileInputStream(file.toFile()));
        } catch (IOException e) {
          System.err.println("Error reading file '" + file + "'");
        }

        try {
          Level l = (Level) ois.readObject();
          levelMap.put(file.toString(), l);
        } catch (NumberFormatException e) {
          // Do something here to load custom levels
        } catch (ClassNotFoundException e) {
          // Improperly formatted file. Ignore it and move on
          e.printStackTrace();
          System.err.println("Error reading from file '" + file + "'");
        } catch (IOException e) {
          // Something went wrong reading the file. Ignore this file and move
          // on.
          e.printStackTrace();
          System.err.println("Error reading from file '" + file + "'");
        }

        // Try to close the stream
        if (ois != null) {
          try {
            ois.close();
          } catch (IOException e) {
            // Oh well. We tried.
          }
        }
      });
    } catch (NotDirectoryException e) {
      System.err.println("Error loading levels. '" + defaultLevelPath + "' is not a directory");
    } catch (IOException e) {
      System.err.println("Error reading from directory '" + defaultLevelPath + "'");
    }
    
    for(String s : levelMap.keySet()) {
      fileList.getItems().add(new Label(s));
    }
  }
}
