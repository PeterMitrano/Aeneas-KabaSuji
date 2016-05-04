package aeneas.controllers;

import aeneas.views.BuildLevelView;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Spinner;

/**
 * @author jbkuszmaul
 */
public class BoardSizeController implements ChangeListener<Integer> {


  private BuildLevelView view;

  public BoardSizeController( BuildLevelView view) {
    this.view = view;
  }

  public void changed(ObservableValue<? extends Integer> observable,
      Integer oldValue, Integer newValue) {
    if(view.isRefreshing()) return;
    Spinner<Integer> rowSpin = view.getRowSpinner();
    Spinner<Integer> colSpin = view.getColumnSpinner();
    Spinner<Integer> changed = (Spinner<Integer>)((ReadOnlyObjectWrapper)observable).getBean();
    IMove move = new SetSizeMove(view.getModel(), rowSpin.getValue(), colSpin.getValue());
    if (move.execute()) view.getLevelModel().addNewMove(move);
    view.refresh();
  }
}
