package aeneas.views;

import aeneas.models.ReleaseNumber;
import aeneas.models.Square;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * View class to display a single square
 * @author Logan
 *
 */
public class SquareView extends StackPane {

  public int size = 16;// in pixels
  private Rectangle square;

  //Square squareModel;

  
  public SquareView(int size, Square s) {
    this.size = size;
    square = new Rectangle();
    //this.squareModel = squareModel;
    square.setWidth(size);
    square.setHeight(size);
    
    square.setStroke(Color.BLACK);
    this.getChildren().add(square);
    if(s != null){
      square.setFill(s.getColor());
      if(s.getNum() != null){
        Label l = new Label(Integer.toString(s.getNum().getValue()));
        l.setTextFill(s.getNum().getColor());
        this.getChildren().add(l);
      }
    }else{
      square.setFill(Color.GRAY);
    }
  }
  
  public void setColor(Color color){
    square.setFill(color);
  }
}
