package aeneas.models;

import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * 
 * @author Joseph Martin
 * @author Logan Tutt
 */
public class ReleaseBoard extends Board implements java.io.Serializable {
  
  ArrayList<ReleaseNumber> numbers;
  
  public ReleaseBoard(ArrayList<ReleaseNumber> numbers){
    if(numbers == null)
      numbers = new ArrayList<ReleaseNumber>();
    else
      this.numbers = numbers;
  }
  
  @Override
  public Square[][] getSquares(){
    Square[][] squares = super.getSquares();
    for(ReleaseNumber num: numbers){
      if(squares[num.getCol()][num.getRow()] == null)
        squares[num.getCol()][num.getRow()] = new Square(num.getRow(), num.getCol(), num, Color.GRAY);
    }
    return squares;
  }


}
