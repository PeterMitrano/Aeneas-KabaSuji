package aeneas.controllers;

import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.views.BuildLevelView;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Spinner;

public class BoardSizeController implements ChangeListener<Integer> {

  private Level level;
  private BuildLevelView view;

  public BoardSizeController(Level level, BuildLevelView view) {
    this.level = level;
    this.view = view;
  }

  public void changed(ObservableValue<? extends Integer> observable,
      Integer oldValue, Integer newValue) {
    Spinner<Integer> rowSpin = view.getRowSpinner();
    Spinner<Integer> colSpin = view.getColumnSpinner();
    Spinner<Integer> changed = (Spinner<Integer>)((ReadOnlyObjectWrapper)observable).getBean();
    int oldCol = colSpin.getValue();
    int oldRow = rowSpin.getValue();
    if (changed == rowSpin) oldRow = oldValue;
    else oldCol = oldValue;
    IMove move = new SetSizeMove(view.getLevelModel(), rowSpin.getValue(), colSpin.getValue(),
                                 oldRow, oldCol);
    if (move.execute()) level.addNewMove(move);
    view.refresh();
  }
}
