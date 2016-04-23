package aeneas.models;

import java.util.ArrayList;

/**
 * 
 * @author Joseph Martin
 */
public class ReleaseBoard extends Board implements java.io.Serializable {
  private static final long serialVersionUID = 1L;

  ArrayList<ReleaseNumber> numbers;

  public ReleaseBoard(ArrayList<ReleaseNumber> numbers) {
    this.numbers = numbers;
  }
  
  public ArrayList<ReleaseNumber> getNumbers() {
    return numbers;
  }
}
