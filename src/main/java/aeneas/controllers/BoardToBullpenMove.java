package aeneas.controllers;
import aeneas.models.Level;
import aeneas.models.Piece;
import aeneas.models.PlacedPiece;
import aeneas.models.Level.LevelWithMoves;

/**
 * Move action  to move a piece from the board to the bullpen
 *
 * @author Logan
 *
 */
public class BoardToBullpenMove implements IMove {
  Level level;
  PlacedPiece piece;

  /**
   * Constructor
   * @param level the level that is being played
   * @param pieceModel the piece to move
   */
  public BoardToBullpenMove(Level level, PlacedPiece boardPiece) {
    this.level = level;
    this.piece = boardPiece;
  }

  @Override
  public boolean execute() {
    if (!isValid()) return false;
    if (level instanceof LevelWithMoves && level.isActive()) {
      ((LevelWithMoves)level).decMoves();
    }
    level.getBoard().removePiece(piece);
    level.getBullpen().addPiece(piece.getPiece());
    return true;
  }

  @Override
  public boolean undo() {
    if(!isValid()) return false;
    // Should probably increment moves here? maybe not necessary
    level.getBullpen().removePiece(piece.getPiece());
    return level.getBoard().addPiece(piece);
  }

  @Override
  public boolean isValid() {
    return true;
  }

}
