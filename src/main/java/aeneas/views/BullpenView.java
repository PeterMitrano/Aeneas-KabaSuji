package aeneas.views;

import java.util.ArrayList;

import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Piece;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

class BullpenView {

  VBox bullpenBox;

  private static final int SQUARE_SIZE = 16;

  ArrayList<Pane> values = new ArrayList<Pane>();

  BullpenView(VBox bullpenBox){
    this.bullpenBox = bullpenBox;
    JFXDepthManager.setDepth(bullpenBox, 1);
    bullpenBox.setAlignment(Pos.TOP_CENTER);
  }

  void addPiece(Piece piece){
    Pane piecePane = new Pane();
    PieceView pieceView = new PieceView(piece, null, SQUARE_SIZE);
    pieceView.setId(piece.toString()); //this relies on all instances having different to strings
    piecePane.getChildren().add(pieceView);
    values.add(piecePane);
    bullpenBox.getChildren().add(piecePane);
  }


}
