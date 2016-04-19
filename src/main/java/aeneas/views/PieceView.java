package aeneas.views;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;

import aeneas.controllers.FlipMove;
import aeneas.controllers.IMove;
import aeneas.controllers.RotateMove;
import aeneas.models.Model;
import aeneas.models.Piece;
import aeneas.models.Square;
import aeneas.models.Piece.Axis;
import aeneas.models.Piece.Dir;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * View class for displaying a Piece
 * 
 */
public class PieceView extends Pane {

  private JFXPopup piecePopup;
  
  
  
  Piece pieceModel;
  Model model;
  int squareSize;
  
  boolean inBullpen;

  /**
   * Constructor
   * @param pieceModel The Piece that this view displays
   * @param model The model that is being used
   * @param squareSize The size of a single square in the piece
   */
  public PieceView(Piece pieceModel, Model model, int squareSize) {
    this.pieceModel = pieceModel;
    this.model = model;
    this.squareSize = squareSize;
    inBullpen = true; //this should be removed once the actual adding of pieces is implemented
    

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
    
    
    //callback for handling clicks on pieces
    this.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
      if(!inBullpen)
        return;
      if(event.getButton().equals(MouseButton.PRIMARY)){
        IMove move = null;
        //control click to flip
        if(event.isControlDown()){
          if(event.isShiftDown()){
            move = new FlipMove(pieceModel, Axis.HORIZONTAL);
          }
          else{
            move = new FlipMove(pieceModel, Axis.VERTICAL);
          }
        }
        //click to rotate
        else {
          if(event.isShiftDown()){
            move = new RotateMove(pieceModel, Dir.COUNTERCLOCKWISE);
          }
          else{
            move = new RotateMove(pieceModel, Dir.CLOCKWISE);
          }
        }
        if(move != null && move.execute()){
          model.addNewMove(move);
          refresh();
        }
      }else if(event.getButton().equals(MouseButton.SECONDARY)){
          piecePopup.setPopupContainer((Pane)this.getParent());
          piecePopup.show(JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, squareSize *1.5, squareSize*1.5);
      }
    });
    
    
    //create labels for popup
    JFXListView<Label> content = new JFXListView<Label>();
    
    Label rotateCW = new Label("rotate CW");
    rotateCW.setOnMouseClicked((MouseEvent event) ->{
      IMove move = new RotateMove(pieceModel, Dir.CLOCKWISE);
      if(move != null && move.execute()){
        model.addNewMove(move);
        refresh();
      }
    });
    content.getItems().add(rotateCW);
    
    Label rotateCCW = new Label("rotate CCW");
    rotateCCW.setOnMouseClicked((MouseEvent event) ->{
      IMove move = new RotateMove(pieceModel, Dir.COUNTERCLOCKWISE);
      if(move != null && move.execute()){
        model.addNewMove(move);
        refresh();
      }
    });
    content.getItems().add(rotateCCW);
    
    Label flipVert = new Label("Flip Vert");
    flipVert.setOnMouseClicked((MouseEvent event) ->{
      IMove move = new FlipMove(pieceModel, Axis.VERTICAL);
      if(move != null && move.execute()){
        model.addNewMove(move);
        refresh();
      }
    });
    content.getItems().add(flipVert);
    
    Label flipHorz = new Label("Flip Horz");
    flipHorz.setOnMouseClicked((MouseEvent event) ->{
      IMove move = new FlipMove(pieceModel, Axis.HORIZONTAL);
      if(move != null && move.execute()){
        model.addNewMove(move);
        refresh();
      }
    });
    content.getItems().add(flipHorz);
    
    piecePopup = new JFXPopup((Pane)this.getParent(),content);
    piecePopup.setSource(this);   
    getChildren().add(piecePopup);
    
    //close popup when mouse leaves
    content.setOnMouseExited((e) -> {
      piecePopup.close();     
    });
    
    
    refresh();
    
  }
  
  /**
   * Refreshes the view to match the stored piece
   */
  public void refresh(){
    this.getChildren().clear();
    for (Square s : pieceModel.getSquares()) {
      SquareView view = new SquareView(squareSize);
      view.setX(s.getRow() * squareSize);
      view.setY(s.getCol() * squareSize);
      getChildren().add(view);
    }
  }
}
