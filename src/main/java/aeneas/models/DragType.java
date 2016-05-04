package aeneas.models;

import javafx.scene.input.DataFormat;

/**
 * Used to specify the type of a dragged object for drag and drop
 */
public abstract class DragType {
  /**
   * Data format spec for DragType
   */
  public static final DataFormat dataFormat = new DataFormat("aeneas.models.DragType");
  /**
   * Type of dragged object
   */
  public enum Type {
    /**
     * Dragged object was a Piece
     */
    Piece,
    /**
     * Dragged object was a ReleaseNumber
     */
    ReleaseNum,
  }
}
