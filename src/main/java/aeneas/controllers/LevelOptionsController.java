package aeneas.controllers;

import aeneas.models.Level;
import aeneas.models.Level.LevelType;
import aeneas.models.LightningLevel;
import aeneas.models.PuzzleLevel;
import aeneas.models.ReleaseLevel;
import aeneas.views.BuildLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles the setting of options on the Level builder.
 *
 * @author jbkuszmaul
 */
public class LevelOptionsController implements EventHandler<MouseEvent> {

  BuildLevelView view;

  public LevelOptionsController(BuildLevelView view) {
    this.view = view;
  }

  @Override
  public void handle(MouseEvent event) {
    refreshLevel();
  }

  /**
   * Refreshes the state of the level based on the current settings for the
   * level options.
   * This does NOT update the level type.
   */
  public void refreshLevel() {
    Level level = view.getLevel();
    IMove move;
    switch (level.getLevelType()) {
      case LIGHTNING:
        move = new SetTimeMove((LightningLevel)level, view.allowedSeconds());
        break;
      case PUZZLE:
      case RELEASE:
      default:
        move = new SetMovesMove(level, view.getMovesAllowed());
        break;
    }
    if (move.execute()) {
      //Register for move.
    }
  }

}
