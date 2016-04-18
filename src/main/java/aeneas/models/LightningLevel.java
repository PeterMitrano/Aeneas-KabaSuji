package aeneas.models;

public class LightningLevel extends Level implements java.io.Serializable {
  public static final String helpText = "";

  LightningBoard board;
  int allowedTime;

  public LightningLevel(Bullpen bullpen, int allowedTime) {
    super(bullpen);
    this.allowedTime = allowedTime;
  }

  public LightningLevel(Level src) {
    super(src);
    if (src instanceof LightningLevel) {
      this.board = ((LightningLevel)src).board;
      this.allowedTime = ((LightningLevel)src).allowedTime;
    }
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
