package aeneas.controllers;
import aeneas.models.Level;
import aeneas.models.PlacedPiece;
import aeneas.models.Level.LevelWithMoves;
import aeneas.models.Model;

/**
 * Move action  to move a piece from the board to the bullpen
 *
 * @author Logan
 * @author Joseph Martin
 * @author jbkuszmaul
 * @author Peter Mitrano
 */
public class BoardToBullpenMove implements IMove {
  Model model;
  PlacedPiece piece;

  /**
   * Constructor
   * @param model the model that is being played
   * @param boardPiece the piece to move
   */
  public BoardToBullpenMove(Model model, PlacedPiece boardPiece) {
    this.model = model;
    this.piece = boardPiece;
  }

  @Override
  public boolean execute() {
    if (!isValid()) return false;
    if (model.getActiveLevel() instanceof LevelWithMoves && model.getActiveLevel().isActive()) {
      ((LevelWithMoves)model.getActiveLevel()).decMoves();
    }
    model.getActiveLevel().getBoard().removePiece(piece);
    model.getActiveLevel().getBullpen().addPiece(piece.getPiece());
    return true;
  }

  @Override
  public boolean undo() {
    if(!isValid()) return false;
    model.getActiveLevel().getBullpen().removePiece(piece.getPiece());
    return model.getActiveLevel().getBoard().addPiece(piece);
  }

  @Override
  public boolean isValid() {
    return true;
  }

}
