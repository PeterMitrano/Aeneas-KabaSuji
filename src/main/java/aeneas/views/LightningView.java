package aeneas.views;

import aeneas.controllers.IMove;
import aeneas.controllers.SetMovesMove;
import aeneas.controllers.SetTimeMove;
import aeneas.models.LightningLevel;
import aeneas.models.ReleaseLevel;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;

public class LightningView extends LevelView {

  private static final RadioButton button = new RadioButton("Lightning");

  
  Spinner<Integer> timeSelect;
  private LightningLevel level;
  
  private boolean isUserInput = true;
  
  
  public LightningView(LightningLevel levelModel){
    super(levelModel);
    
    level = levelModel;

    VBox box = new VBox();
    box.setSpacing(4);

    Label timeLabel = new Label("Time in Seconds");
    timeSelect = new Spinner<Integer>(0, 600, 30);
    timeSelect.setPrefWidth(120);
    int seconds = levelModel.getAllowedTime();
    timeSelect.getValueFactory().setValue(seconds);

    timeSelect.valueProperty().addListener((observer, old_seconds, new_seconds) -> {
      if(!isUserInput) return;
      IMove move = new SetTimeMove(levelModel, new_seconds);
      if(move.execute()){
        levelModel.addNewMove(move);
      }
    });

    box.getChildren().add(timeLabel);
    box.getChildren().add(timeSelect);

    panel.getChildren().add(box);

    button.setUserData(this);
  }

  @Override
  public RadioButton getButton() {
    return LightningView.button;
  }
  
  @Override
  public void updateValues(){
    isUserInput = false;
    timeSelect.getValueFactory().setValue(level.getAllowedTime());
    isUserInput = true;
  }
}
