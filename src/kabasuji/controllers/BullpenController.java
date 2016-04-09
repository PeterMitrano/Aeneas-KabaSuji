package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.PlayLevelView;

public class BullpenController implements EventHandler<MouseEvent> {

  public static class BullpenLogic {
    boolean isEditor;
    boolean canChangePieceType;
    boolean changeNumPieces;
    public static BullpenLogic editorLogic() {return new BullpenLogic();}
    public static BullpenLogic puzzleLogic() {return new BullpenLogic();}
    public static BullpenLogic lightningLogic() {return new BullpenLogic();}
    public static BullpenLogic releaseLogic() {return new BullpenLogic();}
  }

  Level levelModel;
  PlayLevelView view;
  BullpenLogic logic;

  public BullpenController(PlayLevelView view, Level levelModel, BullpenLogic logic){
    this.levelModel = levelModel;
    this.view = view;
    this.logic = logic;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
