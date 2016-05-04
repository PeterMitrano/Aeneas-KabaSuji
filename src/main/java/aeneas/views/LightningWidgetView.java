package aeneas.views;

import aeneas.controllers.IMove;
import aeneas.controllers.SetTimeMove;
import aeneas.models.LightningLevel;
import aeneas.models.Level;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;

/**
 * Widget view for lightning levels.
 *
 * @author Logan Tutt
 * @author Joseph Martin
 */
public class LightningWidgetView extends LevelWidgetView {
  /**
   * A button used for selecting the lightning level type.
   */
  public static final RadioButton button = new RadioButton("Lightning");
  private LightningLevel level;


  Spinner<Integer> timeSelect;

  private boolean isUserInput = true;


  /**
   * Constructor
   * @param levelModel
   */
  public LightningWidgetView(LightningLevel levelModel){
    super(levelModel);

    level = levelModel;

    VBox box = new VBox();
    box.setSpacing(4);

    Label timeLabel = new Label("Time in Seconds");
    timeSelect = new Spinner<Integer>(0, 600, 30);
    timeSelect.setPrefWidth(120);
    int seconds = levelModel.getAllowedTime();
    timeSelect.getValueFactory().setValue(seconds);
    timeSelect.valueProperty().addListener((observer, old_value, new_value) -> {
      if(!isUserInput) return;
      IMove move = new SetTimeMove(level, new_value);
      if(move.execute()){
        level.addNewMove(move);
      }
    });


    box.getChildren().add(timeLabel);
    box.getChildren().add(timeSelect);

    panel.getChildren().add(box);

    button.setUserData(this);
  }

  public Level resetLevelModel(Level level) {
    if (level instanceof LightningLevel) {
      this.level = (LightningLevel)level;
      return level;
    }
    this.level = new LightningLevel(level);
    timeSelect.valueProperty().addListener((observer, old_value, new_value) -> {
      if(!isUserInput) return;
      IMove move = new SetTimeMove(this.level, new_value);
      if(move.execute()){
        level.addNewMove(move);
      }
    });
    updateValues();
    return this.level;
  }

  @Override
  public RadioButton getButton() {
    return LightningWidgetView.button;
  }

  @Override
  public void updateValues(){
    isUserInput = false;
    timeSelect.getValueFactory().setValue(level.getAllowedTime());
    getButton().setSelected(true);
    isUserInput = true;
  }
}
