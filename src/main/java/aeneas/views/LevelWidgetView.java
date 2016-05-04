package aeneas.views;

import aeneas.models.Level;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

/**
 * Abstract base class for widgets that edit parameters for levels
 *
 * @author Logan Tutt
 * @author Joseph Martin
 */
public abstract class LevelWidgetView {


  protected VBox panel;
  private Level levelModel;

  /**
   * Constructor
   * @param levelModel
   */
  public LevelWidgetView(Level levelModel){
    this.levelModel = levelModel;
    panel = new VBox();
    panel.setAlignment(Pos.TOP_LEFT);
    panel.setSpacing(10);
    panel.setMinWidth(125);
  }

  /**
   * @return the panel
   */
  public VBox getPanel() {
    return panel;
  }

  /**
   * @param levelModel the level to reset to
   * @return If levelModel is already of the correct type, then
   *   levelModel will be returned.
   */
  public abstract Level resetLevelModel(Level levelModel);

  /**
   * Gets the default level model for this type of level.
   * @return the default level model for this type of level.
   */
  public Level getDefaultLevelModel() {
    return this.levelModel;
  }

  /**
   * Gets the button to be used for selecting this level type.
   * @return the button.
   */
  public abstract RadioButton getButton();

  /**
   * updates all values in the widget to correspond to the correct values
   */
  public abstract void updateValues();

}
