package aeneas.views;

import com.jfoenix.controls.JFXDatePicker;

import aeneas.models.Level;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LightningView extends LevelView {

  public LightningView(Level levelModel){
    super(levelModel);

    VBox box = new VBox();
    box.setSpacing(4);

    Label timeLabel = new Label("Set A Time");
    JFXDatePicker timeSelect = new JFXDatePicker();
    timeSelect.setDefaultColor(Color.web("#3f51b5"));
    timeSelect.setShowTime(true);
    timeSelect.setPrefWidth(120);

    box.getChildren().add(timeLabel);
    box.getChildren().add(timeSelect);

    panel.getChildren().add(box);

    button = new RadioButton("Lightning");
    button.setUserData(this);
  }

}
