package aeneas.views;

import com.jfoenix.controls.JFXColorPicker;

import aeneas.models.Level;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class ReleaseView extends LevelView {

  private static final RadioButton button = new RadioButton("Release");

  public ReleaseView(Level levelModel){
    super(levelModel);

    VBox box = new VBox();
    box.setSpacing(4);

    JFXColorPicker colorSelect = new JFXColorPicker();
    colorSelect.prefWidth(110);

    box.getChildren().add(colorSelect);

    panel.getChildren().add(box);

    button.setUserData(this);
  }

  @Override
  public RadioButton getButton() {
    return ReleaseView.button;
  }
}

