package aeneas.controllers;

import aeneas.models.Level;
import aeneas.views.PlayLevelView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// I'm thinking that because this class will need to handle so many different
// events, we should not bother inheriting from EventHandler and instead
// just create a bunch of handler functions and use lambdas in the
// view classes to assign different events to different handlers.
// Equivalently, we could continued inheriting from EventHandler and instead
// have switch statements in handle() depending on the MouseEvent...
public class BoardController implements EventHandler<MouseEvent> {

  public static class BoardLogic {
    boolean isEditor;
    boolean canRemovePieces;
    boolean peristentPieces;
    public static BoardLogic editorLogic() {return new BoardLogic(); }
    public static BoardLogic puzzleLogic() {return new BoardLogic(); }
    public static BoardLogic lightningLogic()  {return new BoardLogic(); }
    public static BoardLogic releaseLogic() {return new BoardLogic(); }
  }

  Level levelModel;
  PlayLevelView view;
  BoardLogic logic;

  public BoardController(PlayLevelView view, Level levelModel, BoardLogic logic) {
    this.levelModel = levelModel;
    this.view = view;
    this.logic = logic;
  }

  @Override
  public void handle(MouseEvent event) {
  }

}
