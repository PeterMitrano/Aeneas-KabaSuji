package kabasuji.controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import kabasuji.models.Level;
import kabasuji.views.PlaySelectLevelView;

public class BullpenController implements EventHandler<MouseEvent> {

  class BullpenLogic {
    boolean isEditor;
    boolean canChangePieceType;
    boolean changeNumPieces;
    public static BullpenLogic editorLogic();
    public static BullpenLogic puzzleLogic();
    public static BullpenLogic lightningLogic();
    public static BullpenLogic releaseLogic();
  }

  Level levelModel;
  PlaySelectLevelView view;
  BullpenLogic logic;

  public BullpenController(PlayLevelView view, Level levelModel, BullpenLogic logic){
    this.levelModel = levelModel;
    this.view = view;
    this.logic = logic;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println("enter level " + levelModel.levelNumber);
    view.parentView.switchToPlayLevelView();
  }

}
