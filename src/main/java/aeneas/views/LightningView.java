package aeneas.views;

import aeneas.models.LightningLevel;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;

public class LightningView extends LevelView {

  private static final RadioButton button = new RadioButton("Lightening");

  public LightningView(LightningLevel levelModel){
    super(levelModel);

    VBox box = new VBox();
    box.setSpacing(4);

    Label timeLabel = new Label("Time in Seconds");
    Spinner<Integer> timeSelect = new Spinner<Integer>(0, 600, 30);
    timeSelect.setPrefWidth(120);
    int seconds = levelModel.getAllowedTime();
    timeSelect.getValueFactory().setValue(seconds);

    timeSelect.valueProperty().addListener((observer, old_seconds, new_seconds) -> {
      levelModel.setAllowedTime(new_seconds);
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
}
