package kabasuji.models;

import java.util.ArrayList;

public class ReleaseLevel extends Level {
  public static final String helpText = "";
  
  ReleaseBoard board;
  ArrayList<ReleaseNumber> numbers;
  
  public ReleaseLevel(Bullpen bullpen, ArrayList<ReleaseNumber> numbers) {
    super(bullpen);
    this.numbers = numbers;
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
