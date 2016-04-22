package aeneas.views;

import com.jfoenix.controls.JFXDatePicker;

import aeneas.models.Level;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LightningView extends LevelView {

  public LightningView(Level levelModel){
    super(levelModel);

    VBox box = new VBox();
    box.setSpacing(4);

    JFXDatePicker timeSelect = new JFXDatePicker();
    timeSelect.setDefaultColor(Color.web("#3f51b5"));
    timeSelect.setShowTime(true);
    timeSelect.prefWidth(110);
    
    box.getChildren().add(timeSelect);

    panel.setSpacing(10);
    panel.getChildren().add(box);

    button = new RadioButton("Lightning");
    button.setUserData(this);
  }

}
