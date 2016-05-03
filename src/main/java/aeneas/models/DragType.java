package aeneas.models;

import javafx.scene.input.DataFormat;

/**
 * USed to determine the type of a dragged object
 *
 */
public abstract class DragType {

  public static final DataFormat dataFormat = new DataFormat("aeneas.models.DragType");
  public enum Type {
    Piece,
    ReleaseNum,
  }
}
