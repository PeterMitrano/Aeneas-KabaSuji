package aeneas.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import com.jfoenix.controls.JFXDecorator;

import aeneas.models.Board;
import aeneas.models.Bullpen;
import aeneas.models.Level;
import aeneas.models.LightningLevel;
import aeneas.models.Model;
import aeneas.models.Piece;
import aeneas.models.PuzzleLevel;
import aeneas.models.ReleaseLevel;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuildLevelTest extends ApplicationTest {

  Stage stage;
  MainView mainView;
  BuildLevelView buildView;
  Model model;

  @Override
  public void init() throws Exception {
    FxToolkit.registerStage(() -> new Stage());
  }

  @Override
  public void start(Stage stage) {
    this.stage = stage;
    mainView = new MainView(stage);
    model = mainView.getModel();
    Scene scene = new Scene(new JFXDecorator(stage, mainView.root), 800, 800);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() throws Exception {
    FxToolkit.hideStage();
    FxToolkit.cleanupStages();
  }

  private void navigateToNewBuild() {
    clickOn("#buildSelectLevelButton");
    clickOn("#createNewLevelLabel");
  }

  private void switchToRelease() {
    ReleaseLevel release = new ReleaseLevel(
        new Bullpen(Bullpen.BullpenLogic.releaseLogic()));
    clickOn(release.getButton());
  }

  private void switchToPuzzle() {
    PuzzleLevel puzzle = new PuzzleLevel(
        new Bullpen(Bullpen.BullpenLogic.puzzleLogic()));
    clickOn(puzzle.getButton());
  }

  private void switchToLightning() {
    LightningLevel lightning = new LightningLevel(
        new Bullpen(Bullpen.BullpenLogic.lightningLogic()), 100);
    clickOn(lightning.getButton());
  }

  @Test
  public void testSwitchLevelType() {
    navigateToNewBuild();
    switchToRelease();
    assertTrue(model.getActiveLevel() instanceof ReleaseLevel);
    switchToPuzzle();
    assertTrue(model.getActiveLevel() instanceof PuzzleLevel);
    switchToLightning();
    assertTrue(model.getActiveLevel() instanceof LightningLevel);
  }
}
