package aeneas.controllers;

import aeneas.models.Model;
import aeneas.models.Piece;
import aeneas.models.Piece.Axis;
import aeneas.models.Piece.Dir;
import aeneas.views.PieceView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


/**
 * single click rotates CW, Shift-click rotates CCW
 * ctrl-click flips across vertical axis, shift-ctrl-click flips across horizontal axis
 */
public class ManipulatePieceController implements EventHandler<MouseEvent> {

  Piece pieceModel;
  PieceView pieceView;
  Model model;

  public ManipulatePieceController(Model model, Piece pieceModel, PieceView pieceView) {
    this.pieceModel = pieceModel;
    this.model = model;
    this.pieceView = pieceView;
  }

  @Override
  public void handle(MouseEvent event) {
    if (!pieceModel.inBullpen)
      return;

    if (event.getButton().equals(MouseButton.PRIMARY)) {
      // control click to flip
      if (event.isControlDown()) {
        if (event.isShiftDown()) {
          doMove(Axis.HORIZONTAL);
        } else {
          doMove(Axis.VERTICAL);
        }
      }
      // click to rotate
      else {
        if (event.isShiftDown()) {
          doMove(Dir.COUNTERCLOCKWISE);
        } else {
          doMove(Dir.CLOCKWISE);
        }
      }
    } else if (event.getButton().equals(MouseButton.SECONDARY)) {
      pieceView.showPopup();
    }
  }

  public void doMove(Dir dir) {
    IMove move = new RotateMove(pieceModel, dir);
    if (move != null && move.execute()) {
      model.addNewMove(move);
      pieceView.refresh();
    }
  }

  public void doMove(Axis axis) {
    IMove move = new FlipMove(pieceModel, axis);
    if (move != null && move.execute()) {
      model.addNewMove(move);
      pieceView.refresh();
    }
  }

}
