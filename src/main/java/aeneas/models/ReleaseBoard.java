package aeneas.models;

import java.util.ArrayList;

/**
 * 
 * @author Joseph Martin
 */
public class ReleaseBoard extends Board implements java.io.Serializable {
  ArrayList<ReleaseNumber> numbers;

  public ReleaseBoard(ArrayList<ReleaseNumber> numbers) {
    this.numbers = numbers;
  }
  
  public ArrayList<ReleaseNumber> getNumbers() {
    return numbers;
  }
}
