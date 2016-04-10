package kabasuji.views;

import javafx.scene.paint.Color;

public class SquareColor {

  public static final SquareColor BLUE = new SquareColor("#41508b");
  public static final SquareColor RED = new SquareColor("#e74c3c");
  public static final SquareColor ORANGE = new SquareColor("#d35400");
  public static final SquareColor TORQUISE = new SquareColor("#1abc9c");
  public static final SquareColor MAGENTA = new SquareColor("#9b59b6");
  public static final SquareColor YELLOW = new SquareColor("#f1c40f");
  public static final SquareColor GREEN = new SquareColor("#27ae60");

  private Color color;

  private SquareColor(String hex){
    this.color = Color.web(hex);
  }

  /**
   * @return the color
   */
  public Color getColor() {
    return color;
  }

}

