package aeneas.views;

import java.util.ArrayList;

import com.jfoenix.effects.JFXDepthManager;

import aeneas.models.Bullpen;
import aeneas.models.Model;
import aeneas.models.Piece;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Joseph Martin
 */
public class BullpenView {

  VBox bullpenBox;
  Pane levelView;
  //Bullpen bullpen;
  //Model gameModel;

  static final int SQUARE_SIZE = 16;

  ArrayList<Pane> values = new ArrayList<Pane>();

  //BullpenView(Model model, Bullpen bullpen, VBox bullpenBox, Pane levelView){
    //this.gameModel = model;
    //this.bullpen = bullpen;
  public BullpenView(VBox bullpenBox, Pane levelView){
    this.levelView = levelView;
    this.bullpenBox = bullpenBox;
    JFXDepthManager.setDepth(bullpenBox, 1);
    bullpenBox.setAlignment(Pos.TOP_CENTER);
    //refresh();
  }
  
  public void refresh(Model model, Bullpen bullpen) {

    bullpenBox.getChildren().clear();

    for (int i=bullpen.getPieces().size() - 1; i >= 0; i-- ) {
      Piece piece = bullpen.getPieces().get(i);
      Pane piecePane = new Pane();
      PieceView pieceView = new PieceView(levelView, piece, model, SQUARE_SIZE);
      piecePane.getChildren().add(pieceView);
      values.add(piecePane);
      bullpenBox.getChildren().add(piecePane);
    }
  }
}
