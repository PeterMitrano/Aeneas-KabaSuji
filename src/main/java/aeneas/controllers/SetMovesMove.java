package aeneas.controllers;
import aeneas.models.Level;
import aeneas.models.Level.LevelType;
import aeneas.models.PuzzleLevel;
import aeneas.models.ReleaseLevel;

/**
 * Move action to set the allotted moves for a puzzle level
 * For use in the builder.
 *
 * @author Logan
 * @author jbkuszmaul
 */
public class SetMovesMove implements IMove {

  Level level;

  int oldMoves;
  int newMoves;

  /**
   * Constructor.
   *
   * @param level the level that is being edited
   * @param moves the amount of moves to set the level too. Positive.
   */
  public SetMovesMove(Level level, int moves) {
    this.level = level;
    this.newMoves = moves;
  }

  @Override
  public boolean execute() {
    if (!isValid()) return false;
    switch (level.getLevelType()) {
      case PUZZLE:
        PuzzleLevel p = (PuzzleLevel)level;
        oldMoves = p.getAllowedMoves();
        p.setAllowedMoves(newMoves);
        break;
      case RELEASE:
        ReleaseLevel r = (ReleaseLevel)level;
        oldMoves = r.getAllowedMoves();
        r.setAllowedMoves(newMoves);
        break;
    }
    return true;
  }

  @Override
  public boolean undo() {
    if (!isValid()) return false;
    switch (level.getLevelType()) {
      case PUZZLE:
        PuzzleLevel p = (PuzzleLevel)level;
        p.setAllowedMoves(oldMoves);
        break;
      case RELEASE:
        ReleaseLevel r = (ReleaseLevel)level;
        r.setAllowedMoves(oldMoves);
        break;
    }
    return true;
  }

  @Override
  public boolean isValid() {
    return level != null && newMoves >= 0 &&
           level.getLevelType() != LevelType.LIGHTNING;
  }

}
