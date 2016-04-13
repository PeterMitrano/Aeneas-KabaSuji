package aeneas.views;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareView extends Rectangle {

  public int size = 16;// in pixels

  //Square squareModel;

  public SquareView(int size) {
    this.size = size;
    //this.squareModel = squareModel;
    setWidth(size);
    setHeight(size);
    setFill(Color.BLUE);
    setStroke(Color.BLACK);
  }
}
