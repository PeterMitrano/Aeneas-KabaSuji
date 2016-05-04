package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXDialog.DialogTransition;
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
 * View for the selecting a level to edit
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

  @FXML
  private JFXDialog dialog;

  @FXML
  private JFXButton accept;

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
    return new PuzzleWidgetView(defaultLevel);
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
          levelToSwitchTo.getBoard().setIsEditor(true);
          mainView.switchToBuildLevelView(levelToSwitchTo);
        } else {
          levelToSwitchTo = model.getLevel(Integer.parseInt(text));
          levelToSwitchTo.getBullpen().setLogic(BullpenLogic.editorLogic());
          levelToSwitchTo.getBoard().setIsEditor(true);

          if (levelToSwitchTo == null) {
            System.out.println("couldn't find file level " + text);
          }
        }
      }
    });
    
    dialog.setTransitionType(DialogTransition.CENTER);

    accept.setOnMouseClicked((e) -> {
      dialog.close();
    });

    editLevel.setOnMouseClicked((e) -> {
      if(levelToSwitchTo != null) {
        mainView.switchToBuildLevelView(levelToSwitchTo);
      } else {
        dialog.show(mainView);
      }
    });

    JFXDepthManager.setDepth(fileList, 1);

    refresh();
  }

  public void refresh() {
    levelToSwitchTo = null;
    fileList.getItems().clear();
    fileList.getItems().add(createNewLevelLabel);

    model.getLevelIndex().reindex();

    for(Level l : model.getLevels()) {
      fileList.getItems().add(new Label(l.getLevelNumber()+""));
    }
  }
}
