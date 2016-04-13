package aeneas.models;

public class LightningLevel extends Level {
  public static final String helpText = "";
  
  LightningBoard board;
  int allowedTime;

  public LightningLevel(Bullpen bullpen, int allowedTime) {
    super(bullpen);
    this.allowedTime = allowedTime;
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
