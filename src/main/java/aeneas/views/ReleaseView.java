package aeneas.views;

import com.jfoenix.controls.JFXColorPicker;

import aeneas.models.Level;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class ReleaseView extends LevelView {

  public ReleaseView(Level levelModel){
    super(levelModel);

    VBox box = new VBox();
    box.setSpacing(4);

    JFXColorPicker colorSelect = new JFXColorPicker();
    colorSelect.prefWidth(110);
    
    box.getChildren().add(colorSelect);

    panel.setSpacing(10);
    panel.getChildren().add(box);

    button = new RadioButton("Release");
    button.setUserData(this);
  }

}

