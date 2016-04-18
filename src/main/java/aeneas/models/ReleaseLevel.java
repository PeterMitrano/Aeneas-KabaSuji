package aeneas.models;

import java.util.ArrayList;

public class ReleaseLevel extends Level implements java.io.Serializable {
  public static final String helpText = "";

  ReleaseBoard board;
  ArrayList<ReleaseNumber> numbers;

  public ReleaseLevel(Bullpen bullpen, ArrayList<ReleaseNumber> numbers) {
    super(bullpen);
    this.numbers = numbers;
  }

  public ReleaseLevel(Level src) {
    super(src);
  }

  @Override
  public boolean isComplete() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Board getBoard() {
    return board;
  }

}
