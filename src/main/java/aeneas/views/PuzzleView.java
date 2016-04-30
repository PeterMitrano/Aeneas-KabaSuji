package aeneas.views;

import aeneas.controllers.IMove;
import aeneas.controllers.SetMovesMove;
import aeneas.models.PuzzleLevel;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;

public class PuzzleView extends LevelView {

  static public final RadioButton button = new RadioButton("Puzzle");

  private Spinner<Integer> movesSelect;
  private Label movesLabel;
  private PuzzleLevel level;
  
  private boolean isUserInput = true;

  public PuzzleView(PuzzleLevel levelModel){
    super(levelModel);

    level = levelModel;
    movesLabel = new Label("Moves");
    movesSelect = new Spinner<Integer>(1, 20, 10);
    movesSelect.setPrefWidth(70);
    movesSelect.setEditable(true);
    movesSelect.getValueFactory().setValue(levelModel.getAllowedMoves());
    movesSelect.valueProperty().addListener((observer, old_value, new_value) -> {
      if(!isUserInput) return;
      IMove move = new SetMovesMove(levelModel, new_value);
      if(move.execute()){
        levelModel.addNewMove(move);
      }
    });

    HBox hbox = new HBox();
    hbox.setSpacing(5);
    hbox.setAlignment(Pos.CENTER_LEFT);
    hbox.getChildren().add(movesLabel);
    hbox.getChildren().add(movesSelect);

    panel.getChildren().add(hbox);

    button.setUserData(this);
  }

  @Override
  public RadioButton getButton() {
    return PuzzleView.button;
  }

  @Override
  public void updateValues(){
    isUserInput = false;
    movesSelect.getValueFactory().setValue(level.getAllowedMoves());
    isUserInput = true;
  }

}
