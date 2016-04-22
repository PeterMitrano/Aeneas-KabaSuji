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
      this.numbers = new ArrayList<ReleaseNumber>();
    else
      this.numbers = numbers;
    
    this.numbers.add(new ReleaseNumber(0, 0, ReleaseNumber.color1, 1));
    this.numbers.add(new ReleaseNumber(0, 5, ReleaseNumber.color2, 2));
    this.numbers.add(new ReleaseNumber(5, 5, ReleaseNumber.color3, 3));
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

  public ArrayList<ReleaseNumber> getNumbers() {
    return numbers;
  }
}
