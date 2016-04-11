package kabasuji.models;

public class ReleaseLevel extends Level {
  public static final String helpText = "";
  
  ReleaseBoard board;
  
  public ReleaseLevel(Bullpen bullpen) {
    super(bullpen);
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
