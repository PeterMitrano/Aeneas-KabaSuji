package aeneas.views;

import aeneas.models.Level;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;

public class PuzzleView extends LevelView {

  private Spinner<Integer> movesSelect;
  private Label movesLabel;

  public PuzzleView(Level levelModel){
    super(levelModel);

    movesLabel = new Label("Moves");
    movesSelect = new Spinner<Integer>(1, 20, 10);
    movesSelect.setPrefWidth(70);
    movesSelect.setEditable(true);

    HBox hbox = new HBox();
    hbox.setSpacing(5);
    hbox.setAlignment(Pos.CENTER_LEFT);
    hbox.getChildren().add(movesLabel);
    hbox.getChildren().add(movesSelect);

    panel.getChildren().add(hbox);

    button = new RadioButton("Puzzle");
    button.setPrefWidth(100);
    button.setUserData(this);
  }
}
