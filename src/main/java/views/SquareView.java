package main.java.views;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.java.models.Square;

public class SquareView extends Rectangle {

  public int size = 16;// in pixels

  Square squareModel;

  public SquareView(Square squareModel, int size) {
    this.size = size;
    this.squareModel = squareModel;
    setWidth(size);
    setHeight(size);
    setFill(Color.BLUE);
    setStroke(Color.BLACK);
  }
}
