package aeneas.controllers;

import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.views.BuildLevelView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class BoardSizeController implements ChangeListener<Integer> {

  private Level level;
  private Model model;
  private BuildLevelView view;

  public BoardSizeController(Level level, Model model, BuildLevelView view) {
    this.level = level;
    this.model = model;
    this.view = view;
  }

  public void changed(ObservableValue<? extends Integer> observable,
      Integer oldValue, Integer newValue) {
    IMove move = new SetSizeMove(level, view.getRowSpinner(), view.getColumnSpinner());
    if (move.execute()) model.addNewMove(move);
    view.refresh();
  }
}
