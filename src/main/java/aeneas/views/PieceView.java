package aeneas.views;

import aeneas.models.Piece;
import aeneas.models.Square;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PieceView extends Pane {

  Piece pieceModel;

  public PieceView(Piece pieceModel, int squareSize) {
    this.pieceModel = pieceModel;
    for (Square s : pieceModel.getSquares()) {
      SquareView view = new SquareView(squareSize);
      view.setX(s.getRow() * squareSize);
      view.setY(s.getCol() * squareSize);
      getChildren().add(view);
    }

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
      PieceView fullSizedPieceView = new PieceView(pieceModel, BoardView.SQUARE_SIZE);

      Image snapshotImage = fullSizedPieceView.snapshot(snapshotParameters, null);
      db.setDragView(snapshotImage);

      event.consume();
    });
  }
}
