package aeneas.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import com.jfoenix.controls.JFXDecorator;

import aeneas.models.Board;
import aeneas.models.Level;
import aeneas.models.Model;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoardControlTest extends ApplicationTest {

  Stage stage;
  MainView mainView;

  @Override
  public void init() throws Exception {
    FxToolkit.registerStage(() -> new Stage());
  }

  @Override
  public void start(Stage stage) {
    this.stage = stage;
    mainView = new MainView(stage);
    Scene scene = new Scene(new JFXDecorator(stage, mainView.root), 800, 800);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() throws Exception {
    FxToolkit.hideStage();
    FxToolkit.cleanupStages();
  }

  @Test
  public void testSetSizeBoard() {
    // check adding pieces to bullpen
    clickOn("#buildSelectLevelButton");
    clickOn("#createNewLevelLabel");
    int rows = 3;
    int cols = 2;
    clickOn("#rowSpinner");
    clickOn("#rowSpinner").type(KeyCode.DIGIT3).type(KeyCode.ENTER);
    clickOn("#columnSpinner");
    clickOn("#columnSpinner").type(KeyCode.DIGIT2).type(KeyCode.ENTER);

    Level level = mainView.getModel().getActiveLevel();
    Board board = level.getBoard();
    boolean[][] squares = board.getSquares();
    System.out.println(squares);
    for (int i = 0; i < Board.MAX_SIZE; ++i) {
      for (int j = 0; j < Board.MAX_SIZE; ++j) {
        if (i >= rows || j >= cols) assertFalse(squares[i][j]);
        else assertTrue(squares[i][j]);
      }
    }

    clickOn("#undoButton");
    clickOn("#undoButton");

    for (int i = 0; i < Board.MAX_SIZE; ++i) {
      for (int j = 0; j < Board.MAX_SIZE; ++j) {
        assertTrue(squares[i][j]);
      }
    }
  }
}
