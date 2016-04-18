package aeneas.views;

import aeneas.controllers.FlipMove;
import aeneas.controllers.IMove;
import aeneas.controllers.RotateMove;
import aeneas.models.Model;
import aeneas.models.Piece;
import aeneas.models.Square;
import aeneas.models.Piece.Axis;
import aeneas.models.Piece.Dir;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PieceView extends Pane {

  Piece pieceModel;
  Model model;
  int squareSize;
  
  boolean inBullpen;

  public PieceView(Piece pieceModel, Model model, int squareSize) {
    this.pieceModel = pieceModel;
    this.model = model;
    this.squareSize = squareSize;
    inBullpen = true;
    refresh();

    // callback for when drags are initiated
    this.setOnDragDetected((MouseEvent event) -> {
      Dragboard db = this.startDragAndDrop(TransferMode.MOVE);
      ClipboardContent content = new ClipboardContent();

      // this is what we use to get the object on the other end
      // probably should change it later to a momento/serialized object
      content.putString(this.toString());

      db.setContent(content);

      SnapshotParameters snapshotParameters = new SnapshotParameters();
      snapshotParameters.setFill(Color.TRANSPARENT); // i3 doesn't handle this

      //create a new piece view just for the dragging so it can have a different size
      PieceView fullSizedPieceView = new PieceView(pieceModel, model, BoardView.SQUARE_SIZE);

      Image snapshotImage = fullSizedPieceView.snapshot(snapshotParameters, null);
      db.setDragView(snapshotImage);

      event.consume();
    });

    this.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
      System.out.println("got mouse event");
      if(!inBullpen)
        return;
      if(event.getButton().equals(MouseButton.PRIMARY)){
        IMove move = null;
        if(event.isControlDown()){
          if(event.isShiftDown()){
            move = new FlipMove(pieceModel, Axis.HORIZONTAL);
          }
          else{
            move = new FlipMove(pieceModel, Axis.VERTICAL);
          }
        }
        else if(event.getClickCount() % 2 == 0 ){
          if(event.isShiftDown()){
            move = new RotateMove(pieceModel, Dir.COUNTERCLOCKWISE);
          }
          else{
            move = new RotateMove(pieceModel, Dir.CLOCKWISE);
          }
        }
        if(move != null && move.execute()){
          //model.addNewMove(move);
          System.out.println("move done");
          refresh();
        }
      }
    });
  }
  
  
  private void refresh(){
    this.getChildren().clear();
    for (Square s : pieceModel.getSquares()) {
      SquareView view = new SquareView(squareSize);
      view.setX(s.getRow() * squareSize);
      view.setY(s.getCol() * squareSize);
      getChildren().add(view);
    }
  }
}
