package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.PlayLevelView;

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

  Level levelModel;
  BullpenLogic logic;

  public BullpenController(Level levelModel, BullpenLogic logic) {
    this.levelModel = levelModel;
    this.logic = logic;
  }

  @Override
  public void handle(MouseEvent event) {
    if (logic.canAddNewPiece) {
      //levelModel.getBullpen().addPiece();
    }

    //this should be on Drop
    if (logic.canReturnPiece) {
    }
  }

}
