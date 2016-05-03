package aeneas.views;

/**
 * INterface for things that can be dragged from
 * @author Logan
 *
 */
public interface DragSource {
  /**
   * returns the thing that was dragged off to the source
   */
  public void returnDraggableNode();

  /**
   * tells the source that the drag was successful
   */
  public void dragSuccess();
}
