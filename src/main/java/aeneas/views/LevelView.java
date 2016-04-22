package aeneas.views;

import aeneas.models.Level;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class LevelView {

  protected RadioButton button;
  protected VBox panel;
  public Level levelModel;

  public LevelView(Level levelModel){
    this.levelModel = levelModel;
    panel = new VBox();
    button = new RadioButton();
  }

  /**
   * @return the button
   */
  public RadioButton getButton() {
    return button;
  }

  /**
   * @return the panel
   */
  public VBox getPanel() {
    return panel;
  }

}
