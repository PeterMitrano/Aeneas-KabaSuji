package aeneas.controllers;

import aeneas.models.Bullpen;
import aeneas.models.Piece;
import aeneas.views.BullpenView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BullpenController implements EventHandler<MouseEvent> {

  public static class BullpenLogic {
    private boolean canReturnPiece;
    private boolean canAddNewPiece;

    public static BullpenLogic editorLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = true;
      b.canReturnPiece = true;
      return b;
    }

    public static BullpenLogic puzzleLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = false;
      b.canReturnPiece = true;
      return b;
    }

    public static BullpenLogic lightningLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = false;
      b.canReturnPiece = false;
      return b;
    }

    public static BullpenLogic releaseLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = false;
      b.canReturnPiece = false;
      return b;
    }
  }

  Bullpen bullpenModel;
  BullpenView bullpenView;
  BullpenLogic logic;

  public BullpenController(Bullpen bullpenModel, BullpenView bullpenView, BullpenLogic logic) {
    this.bullpenModel = bullpenModel;
    this.bullpenView = bullpenView;
    this.logic = logic;
  }

  @Override
  public void handle(MouseEvent event) {
  }

  public void returnPiece(Piece pieceModel) {
    if (logic.canReturnPiece) {
      bullpenModel.addPiece(pieceModel);
      bullpenView.refresh();
    }
  }

  public void addPiece(Piece pieceModel) {
    if (logic.canAddNewPiece) {
      bullpenModel.addPiece(pieceModel);
      bullpenView.refresh();
    }
  }
}
