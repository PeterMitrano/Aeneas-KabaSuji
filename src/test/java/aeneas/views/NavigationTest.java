package aeneas.views;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import com.jfoenix.controls.JFXDecorator;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NavigationTest extends ApplicationTest {

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
  public void testNavigate() {
    clickOn("#playSelectLevelButton");
    clickOn("#back");
    clickOn("#viewAchievementsButton");
    clickOn("#back");
    clickOn("#buildSelectLevelButton");
    clickOn("#createNewLevelLabel");
    clickOn("#back");
    clickOn("#back");

    // hit back again to see if it breaks something
    clickOn("#back");
  }

  @Test
  public void testAddPiecesInEditor() {
    // check adding pieces to bullpen
    clickOn("#buildSelectLevelButton");
    clickOn("#createNewLevelLabel");
    clickOn("#addPiece");

    VBox bullpenBox = (VBox) lookup("#bullpenBox").query();
    assertEquals(bullpenBox.getChildren().size(), 0);

    FlowPane piecesPane = (FlowPane) lookup("#piecesPane").query();

    int expectedPieces = 0;
    for (int i = 0; i < 10; i++) {
      PieceView aPiece = (PieceView) piecesPane.getChildren().get(i);
      clickOn(aPiece);
      assertEquals(bullpenBox.getChildren().size(), ++expectedPieces);
    }

    clickOn(bullpenBox); // Clear out the piecePane dialog.

    for (; bullpenBox.getChildren().size() > 0;) {
      Pane piecePane = (Pane) bullpenBox.getChildren().get(0);
      FontAwesomeIconView trash =
          (FontAwesomeIconView)lookup("#trash").query();
      drag(piecePane.getChildren().get(0)).dropTo(trash);
      assertEquals(bullpenBox.getChildren().size(), --expectedPieces);
    }
  }
}
