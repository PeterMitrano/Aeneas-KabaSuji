package aeneas.views;

import com.jfoenix.controls.JFXColorPicker;

import aeneas.controllers.IMove;
import aeneas.controllers.SetMovesMove;
import aeneas.models.ReleaseLevel;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ReleaseWidgetView extends LevelWidgetView {

  private static final RadioButton button = new RadioButton("Release");
  
  Spinner<Integer> movesSelect;
  private ReleaseLevel level;

  private boolean isUserInput = true;
  
  
  public ReleaseWidgetView(ReleaseLevel levelModel){
    super(levelModel);

    level = levelModel;
    movesSelect = new Spinner<Integer>(1, 20, 10);
    Label movesLabel = new Label("Moves");
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


    VBox box = new VBox();
    box.setSpacing(4);

    HBox movesBox = new HBox();
    movesBox.setSpacing(5);
    movesBox.setAlignment(Pos.CENTER_LEFT);
    movesBox.getChildren().add(movesLabel);
    movesBox.getChildren().add(movesSelect);


    JFXColorPicker colorSelect = new JFXColorPicker();
    colorSelect.prefWidth(110);

    box.getChildren().add(movesBox);
    box.getChildren().add(colorSelect);

    panel.getChildren().add(box);

    button.setUserData(this);
  }

  @Override
  public RadioButton getButton() {
    return ReleaseWidgetView.button;
  }
  
  @Override
  public void updateValues(){
    isUserInput = false;
    movesSelect.getValueFactory().setValue(level.getAllowedMoves());
    isUserInput = true;
  }
}

