package main.java.models;

public class Level {

  public int levelNumber;
  public int starsEarned = 2;

  public Board board;

  public Level() {
    board = new Board();
  }
}
