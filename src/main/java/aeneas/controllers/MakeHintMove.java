package aeneas.controllers;
import aeneas.models.Piece;
import javafx.scene.paint.Color;

/**
 * Move action to create a new hint
 * @author Logan, Garrison
 * @author jbkuszmaul
 */
public class MakeHintMove implements IMove {

  Piece piece;
  Color color;

  int row;
  int col;

  /**
   * Constructor
   * @param piece The piece that is being used to make the hint
   */
  public MakeHintMove(Piece piece) {
    this.piece = piece;
    this.color = piece.getColor();
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
    piece.setColor(color);
    return true;
  }

  @Override
  public boolean isValid() {
    // TODO Auto-generated method stub
    return true;
  }

}
