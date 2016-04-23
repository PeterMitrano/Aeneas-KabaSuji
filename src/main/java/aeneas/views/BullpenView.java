package aeneas.views;

import java.util.ArrayList;

import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Bullpen;
import aeneas.models.Model;
import aeneas.models.Piece;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

class BullpenView {

  VBox bullpenBox;
  Pane levelView;
  Bullpen bullpen;
  Model gameModel;

  private static final int SQUARE_SIZE = 16;

  ArrayList<Pane> values = new ArrayList<Pane>();

  BullpenView(Model model, Bullpen bullpen, VBox bullpenBox, Pane levelView){
    this.gameModel = model;
    this.bullpen = bullpen;
    this.levelView = levelView;
    this.bullpenBox = bullpenBox;
    JFXDepthManager.setDepth(bullpenBox, 1);
    bullpenBox.setAlignment(Pos.TOP_CENTER);
    refresh();
  }

  void refresh() {
    bullpenBox.getChildren().clear();
    for(Piece p : bullpen.getPieces()) {
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(levelView, p, gameModel, SQUARE_SIZE);
      pieceView.setId(p.toString()); //this relies on all instances having different to strings
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
      bullpenBox.getChildren().add(piecePane);
    }
  }
}
