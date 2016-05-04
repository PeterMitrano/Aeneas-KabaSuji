package aeneas.views;

import aeneas.models.ReleaseNumber;
import aeneas.models.Square;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * View class to display a single square
 *
 * @author Logan Tutt
 * @author Joseph Martin
 * @author Peter Mitrano
 */
public class SquareView extends StackPane {
  /**
   * The size to draw this square at, in pixels.
   */
  public int size = 16;
  private Rectangle square;
  private Label l;

  /**
   * Create a new square view with with the given size, representing the given square model.
   * @param size The size to draw the square at.
   * @param s The square model to use.
   */
  public SquareView(int size, Square s) {
    this.size = size;
    square = new Rectangle();
    square.setWidth(size);
    square.setHeight(size);

    square.setStroke(Color.BLACK);
    this.getChildren().add(square);
    if (s != null) {
      square.setFill(s.getColor());
      if (s.getNum() != null) {
        setNumber(s.getNum());
      }
    } else {
      square.setFill(Color.BLACK);
    }
  }

  /**
   * Set a number to be drawn.
   * @param num The release number to be drawn in this view.
   */
  public void setNumber(ReleaseNumber num) {
    if (num != null) {
      l = new Label(Integer.toString(num.getValue()));
      l.setTextFill(num.getColor());
      l.setFont(new Font(20));
      l.setBackground(new Background(new BackgroundFill(Color.web("#ffffff00"),
          new CornerRadii(2, false), new Insets(0, 0, 0, 0))));
      this.getChildren().clear();
      this.getChildren().add(square);
      this.getChildren().add(l);
    }
    else {
      //TODO: Hax on hax on hax
      this.getChildren().clear();
      this.getChildren().add(square);
    }
  }

  /**
   * Set the background color of this view.
   * @param color The color to set.
   */
  public void setColor(Color color) {
    square.setFill(color);
  }

  /**
   * Refresh this square view with the given square model.
   * @param square The square model to update with.
   */
  public void refresh(Square square) {
    if (square != null) {
      setColor(square.getColor());
      setNumber(square.getNum());
    } else {
      setColor(Color.BLACK);
      setNumber(null);
    }
  }
}
