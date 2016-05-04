package aeneas.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import aeneas.models.Piece;
import aeneas.models.Square;
import aeneas.models.Piece.Axis;
import aeneas.models.Piece.Dir;

public class FlipAndRotateTest {

  @Test
  public void test() {


    int[][] initSquares ={
      {0,0},
      {0,1},
      {1,0},
      {2,0},
      {2,1},
      {3,0}
    };

    Square[] squares = {
        new Square(initSquares[0][0],initSquares[0][1]),
        new Square(initSquares[1][0],initSquares[1][1]),
        new Square(initSquares[2][0],initSquares[2][1]),
        new Square(initSquares[3][0],initSquares[3][1]),
        new Square(initSquares[4][0],initSquares[4][1]),
        new Square(initSquares[5][0],initSquares[5][1])
    };

    Piece piece =new Piece(squares);


    //test horizontal flip
    IMove move = new FlipMove(piece, Axis.VERTICAL);
    move.execute();

    Square[] result = piece.getSquares();

    assertEquals(3,result[0].getRow());
    assertEquals(0,result[0].getCol());

    assertEquals(3,result[1].getRow());
    assertEquals(1,result[1].getCol());

    assertEquals(2,result[2].getRow());
    assertEquals(0,result[2].getCol());

    assertEquals(1,result[3].getRow());
    assertEquals(0,result[3].getCol());

    assertEquals(1,result[4].getRow());
    assertEquals(1,result[4].getCol());

    assertEquals(0,result[5].getRow());
    assertEquals(0,result[5].getCol());

    move.undo();

    assertEquals(initSquares[0][0],result[0].getRow());
    assertEquals(initSquares[0][1],result[0].getCol());

    assertEquals(initSquares[1][0],result[1].getRow());
    assertEquals(initSquares[1][1],result[1].getCol());

    assertEquals(initSquares[2][0],result[2].getRow());
    assertEquals(initSquares[2][1],result[2].getCol());

    assertEquals(initSquares[3][0],result[3].getRow());
    assertEquals(initSquares[3][1],result[3].getCol());

    assertEquals(initSquares[4][0],result[4].getRow());
    assertEquals(initSquares[4][1],result[4].getCol());

    assertEquals(initSquares[5][0],result[5].getRow());
    assertEquals(initSquares[5][1],result[5].getCol());


    //test vertical flip
    move = new FlipMove(piece, Axis.HORIZONTAL);
    move.execute();

    result = piece.getSquares();

    assertEquals(0,result[0].getRow());
    assertEquals(1,result[0].getCol());

    assertEquals(0,result[1].getRow());
    assertEquals(0,result[1].getCol());

    assertEquals(1,result[2].getRow());
    assertEquals(1,result[2].getCol());

    assertEquals(2,result[3].getRow());
    assertEquals(1,result[3].getCol());

    assertEquals(2,result[4].getRow());
    assertEquals(0,result[4].getCol());

    assertEquals(3,result[5].getRow());
    assertEquals(1,result[5].getCol());

    move.undo();

    assertEquals(initSquares[0][0],result[0].getRow());
    assertEquals(initSquares[0][1],result[0].getCol());

    assertEquals(initSquares[1][0],result[1].getRow());
    assertEquals(initSquares[1][1],result[1].getCol());

    assertEquals(initSquares[2][0],result[2].getRow());
    assertEquals(initSquares[2][1],result[2].getCol());

    assertEquals(initSquares[3][0],result[3].getRow());
    assertEquals(initSquares[3][1],result[3].getCol());

    assertEquals(initSquares[4][0],result[4].getRow());
    assertEquals(initSquares[4][1],result[4].getCol());

    assertEquals(initSquares[5][0],result[5].getRow());
    assertEquals(initSquares[5][1],result[5].getCol());


    //test CW rotation
    move = new RotateMove(piece, Dir.CLOCKWISE);
    move.execute();

    result = piece.getSquares();

    assertEquals(0,result[0].getRow());
    assertEquals(3,result[0].getCol());

    assertEquals(1,result[1].getRow());
    assertEquals(3,result[1].getCol());

    assertEquals(0,result[2].getRow());
    assertEquals(2,result[2].getCol());

    assertEquals(0,result[3].getRow());
    assertEquals(1,result[3].getCol());

    assertEquals(1,result[4].getRow());
    assertEquals(1,result[4].getCol());

    assertEquals(0,result[5].getRow());
    assertEquals(0,result[5].getCol());

    move.undo();

    assertEquals(initSquares[0][0],result[0].getRow());
    assertEquals(initSquares[0][1],result[0].getCol());

    assertEquals(initSquares[1][0],result[1].getRow());
    assertEquals(initSquares[1][1],result[1].getCol());

    assertEquals(initSquares[2][0],result[2].getRow());
    assertEquals(initSquares[2][1],result[2].getCol());

    assertEquals(initSquares[3][0],result[3].getRow());
    assertEquals(initSquares[3][1],result[3].getCol());

    assertEquals(initSquares[4][0],result[4].getRow());
    assertEquals(initSquares[4][1],result[4].getCol());

    assertEquals(initSquares[5][0],result[5].getRow());
    assertEquals(initSquares[5][1],result[5].getCol());

    //test CCW rotation
    move = new RotateMove(piece, Dir.COUNTERCLOCKWISE);
    move.execute();

    result = piece.getSquares();

    assertEquals(1,result[0].getRow());
    assertEquals(0,result[0].getCol());

    assertEquals(0,result[1].getRow());
    assertEquals(0,result[1].getCol());

    assertEquals(1,result[2].getRow());
    assertEquals(1,result[2].getCol());

    assertEquals(1,result[3].getRow());
    assertEquals(2,result[3].getCol());

    assertEquals(0,result[4].getRow());
    assertEquals(2,result[4].getCol());

    assertEquals(1,result[5].getRow());
    assertEquals(3,result[5].getCol());

    move.undo();

    assertEquals(initSquares[0][0],result[0].getRow());
    assertEquals(initSquares[0][1],result[0].getCol());

    assertEquals(initSquares[1][0],result[1].getRow());
    assertEquals(initSquares[1][1],result[1].getCol());

    assertEquals(initSquares[2][0],result[2].getRow());
    assertEquals(initSquares[2][1],result[2].getCol());

    assertEquals(initSquares[3][0],result[3].getRow());
    assertEquals(initSquares[3][1],result[3].getCol());

    assertEquals(initSquares[4][0],result[4].getRow());
    assertEquals(initSquares[4][1],result[4].getCol());

    assertEquals(initSquares[5][0],result[5].getRow());
    assertEquals(initSquares[5][1],result[5].getCol());

  }

}
