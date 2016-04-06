package kabasuji.views;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import kabasuji.models.Square;

public class SquareView extends Rectangle {

  public static final int SIZE = 16;//in pixels

  Square squareModel;

  public SquareView(Square squareModel){
    this.squareModel = squareModel;
    setWidth(SIZE);
    setHeight(SIZE);
    setFill(Color.BLUE);
  }
}

