package kabasuji.views;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import kabasuji.models.Square;

public class SquareView extends Rectangle {

  public int size;

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
