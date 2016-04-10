package kabasuji.views;

import com.jfoenix.effects.JFXDepthManager;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import kabasuji.models.Square;

public class SquareView {
  private Rectangle rectangle;
  private Square squareModel;

  public int size;

  public SquareView(Square squareModel, int size) {
    this.size = size;
    this.squareModel = squareModel;
    rectangle = new Rectangle();
    rectangle.setWidth(size);
    rectangle.setHeight(size);
    rectangle.setFill(Color.BLUE);
    JFXDepthManager.setDepth(rectangle, 1);
  }

  /**
   * @return the rectangle
   */
  public Rectangle getRectangle() {
    return rectangle;
  }

  public void setX(int x) {
    rectangle.setX(x);
  }

  public void setY(int y) {
    rectangle.setY(y);
  }

  public void setColor(SquareColor color) {
    rectangle.setFill(color.getColor());
  }
}
