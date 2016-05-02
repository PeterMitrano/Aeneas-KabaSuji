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
import aeneas.models.Piece;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieceManipulationTest extends ApplicationTest {

  Stage stage;
  MainView mainView;
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
    model.getLevelIndex().set_get_opt_levels(false);
    model.getLevelIndex().reindex();
    Scene scene = new Scene(new JFXDecorator(stage, mainView.root), 800, 800);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() throws Exception {
    FxToolkit.hideStage();
    FxToolkit.cleanupStages();
  }

  private void navigateToLevel(int level_num) {
    clickOn("#playSelectLevelButton");
    Level level = model.getLevel(level_num);
    model.getMetadata(level).setLocked(false);
    //Platform.runLater(() -> mainView.switchToPlayLevelView(level));
    GridPane levels = (GridPane) lookup("#levelGrid").query();
    model.getLevelIndex().reindex();
    clickOn(levels.getChildren().get(level_num*2 - 1));
  }

  private PieceView getFirstPiece() {
    VBox bullpenBox = (VBox) lookup("#bullpenBox").query();
    Pane piecePane = (Pane) bullpenBox.getChildren().get(0);
    PieceView piece = (PieceView) piecePane.getChildren().get(0);
    return piece;
  }

  @Test
  public void testRotatePiece() {
    navigateToLevel(1);
    PieceView piece = getFirstPiece();
    Piece oldPiece = piece.pieceModel.clone();
    clickOn(piece);
    oldPiece.rotate(Piece.Dir.CLOCKWISE);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());
    press(KeyCode.SHIFT).clickOn(piece).release(KeyCode.SHIFT);
    oldPiece.rotate(Piece.Dir.COUNTERCLOCKWISE);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());
  }

  @Test
  public void testFlipPiece() {
    navigateToLevel(1);
    PieceView piece = getFirstPiece();
    Piece oldPiece = piece.pieceModel.clone();
    // Now, test flips.
    press(KeyCode.CONTROL).clickOn(piece).release(KeyCode.CONTROL);
    oldPiece.flip(Piece.Axis.VERTICAL);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());

    press(KeyCode.CONTROL).press(KeyCode.SHIFT).clickOn(piece).release(KeyCode.CONTROL).release(KeyCode.SHIFT);
    oldPiece.flip(Piece.Axis.HORIZONTAL);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());
  }

  BoardView boardView;
  VBox bullpenBox;

  public void testDragPieceSetup(int level_num) {
    navigateToLevel(level_num);
    bullpenBox = (VBox) lookup("#bullpenBox").query();
    VBox boardBox = (VBox) lookup("#centerBox").query();
    ObservableList<Node> children = boardBox.getChildren();
    boardView = (BoardView) children.get(children.size()-1);
  }

  @Test
  public void testDragPuzzle() {
    testDragPieceSetup(1);

    Pane piecePane = (Pane) bullpenBox.getChildren().get(0);
    // First, drag piece to board.
    drag(piecePane.getChildren().get(0)).dropTo(boardView.grid[0][0]);
    assertEquals(1, boardView.board.getPieces().size());

    // Now, drag piece back to Bullpen.
    drag(boardView.grid[0][0]).dropTo(bullpenBox);
    assertEquals(0, boardView.board.getPieces().size());

    piecePane = (Pane) bullpenBox.getChildren().get(0);
    // Now, drag to invalid spot on board.
    drag(piecePane.getChildren().get(0)).dropTo(boardView.grid[11][11]);
    assertEquals(0, boardView.board.getPieces().size());
  }

  @Test
  public void testDragLightning() throws InterruptedException {
    testDragPieceSetup(2);

    Pane piecePane = (Pane) bullpenBox.getChildren().get(0);
    // First, drag piece to board.
    drag(piecePane.getChildren().get(0)).dropTo(boardView.grid[0][0]);
    assertEquals(0, boardView.board.getPieces().size());
  }

  @Test
  public void testDragRelease() {
    testDragPieceSetup(3);

    Pane piecePane = (Pane) bullpenBox.getChildren().get(0);
    // First, drag piece to board.
    drag(piecePane.getChildren().get(0)).dropTo(boardView.grid[0][0]);
    assertEquals(1, boardView.board.getPieces().size());

    // Now, drag piece back to Bullpen.
    drag(boardView.grid[0][0]).dropTo(bullpenBox);
    assertEquals(0, boardView.board.getPieces().size());

    piecePane = (Pane) bullpenBox.getChildren().get(0);
    // Now, drag to invalid spot on board.
    drag(piecePane.getChildren().get(0)).dropTo(boardView.grid[11][11]);
    assertEquals(0, boardView.board.getPieces().size());
  }
}
