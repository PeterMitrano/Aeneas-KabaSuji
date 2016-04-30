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

  private void navigateToFirstLevel() {
    clickOn("#playSelectLevelButton");
    GridPane levels = (GridPane) lookup("#levelGrid").query();
    clickOn(levels.getChildren().get(0));
  }

  private PieceView getFirstPiece() {
    VBox bullpenBox = (VBox) lookup("#bullpenBox").query();
    Pane piecePane = (Pane) bullpenBox.getChildren().get(0);
    PieceView piece = (PieceView) piecePane.getChildren().get(0);
    return piece;
  }

  @Test
  public void testRotatePiece() {
    navigateToFirstLevel();
    PieceView piece = getFirstPiece();
    Piece oldPiece = piece.pieceModel.clone();
    clickOn(piece);
    oldPiece.rotate(Piece.Dir.CLOCKWISE);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());
    System.out.println("CCW: ");
    press(KeyCode.SHIFT).clickOn(piece).release(KeyCode.SHIFT);
    oldPiece.rotate(Piece.Dir.COUNTERCLOCKWISE);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());
  }

  @Test
  public void testFlipPiece() {
    navigateToFirstLevel();
    PieceView piece = getFirstPiece();
    Piece oldPiece = piece.pieceModel.clone();
    // Now, test flips.
    press(KeyCode.CONTROL).clickOn(piece).release(KeyCode.CONTROL);
    oldPiece.flip(Piece.Axis.VERTICAL);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());

    System.out.println("Horizontal: ");
    press(KeyCode.CONTROL).press(KeyCode.SHIFT).clickOn(piece).release(KeyCode.CONTROL).release(KeyCode.SHIFT);
    oldPiece.flip(Piece.Axis.HORIZONTAL);
    assertEquals(oldPiece.toString(), piece.pieceModel.toString());
  }

  @Test
  public void testDragPiece() {
    navigateToFirstLevel();
    VBox bullpenBox = (VBox) lookup("#bullpenBox").query();
    Pane piecePane = (Pane) bullpenBox.getChildren().get(0);
    PieceView piece = (PieceView) piecePane.getChildren().get(0);
    VBox boardBox = (VBox) lookup("#centerBox").query();
    ObservableList<Node> children = boardBox.getChildren();
    BoardView boardView = (BoardView) children.get(children.size()-1);

    // First, drag piece to board.
    drag(piece).dropTo(boardView.grid[0][0]);
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
