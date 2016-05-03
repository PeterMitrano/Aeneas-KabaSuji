package aeneas.controllers;
import aeneas.models.Level;
import aeneas.models.Piece;

/**
 * Move action to create a new hint
 * @author Logan, Garrison
 *
 */
public class MakeHintMove implements IMove {

  Level level;

  Piece piece;

  int row;
  int col;

  /**
   * Constructor
   * @param piece The piece that is being used to make the hint
   */
  public MakeHintMove(Piece piece) {
    this.piece = piece;
  }

  @Override
  public boolean execute() {
   if(isValid()){
     piece.setHint(true);
    return true;
    }
   else
     return false;
  }

  @Override
  public boolean undo() {
    piece.setHint(false);
    return false;
  }

  @Override
  public boolean isValid() {
    // TODO Auto-generated method stub
    return true;
  }

}
