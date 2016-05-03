package aeneas.views;

import aeneas.models.Level;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

/**
 *
 * @author Logan Tutt
 * @author Joseph Martin
 */
public abstract class LevelWidgetView {


  protected VBox panel;
  private Level levelModel;

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

  public Level getDefaultLevelModel() {
    return this.levelModel;
  }

  public abstract RadioButton getButton();

  public abstract void updateValues();

}
