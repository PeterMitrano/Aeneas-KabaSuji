package aeneas.models;

/**
 * A factory to get the hexonimoes based on their number from 0-35.
 * @author Joseph Martin
 */
public class PieceFactory {
  public static Piece[] pieces = {
    new Piece(new Square[] {
      new Square(0,0),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0),
      new Square(4,0),
      new Square(5,0)
    }),
    new Piece(new Square[] {
      new Square(0,1),
      new Square(0,0),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0),
      new Square(4,0)
    }),
    new Piece(new Square[] {
      new Square(1,1),
      new Square(0,0),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0),
      new Square(4,0)
    }),
    new Piece(new Square[] {
      new Square(2,1),
      new Square(0,0),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0),
      new Square(4,0)
    }),
    new Piece(new Square[] {
      new Square(0,1),
      new Square(1,1),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0),
      new Square(4,0)
    }),
    new Piece(new Square[] {
      new Square(0,1),
      new Square(0,0),
      new Square(1,1),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(0,1),
      new Square(1,0),
      new Square(2,1),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(0,1),
      new Square(1,0),
      new Square(2,0),
      new Square(3,1),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(1,1),
      new Square(1,0),
      new Square(2,1),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0),
      new Square(0,1),
      new Square(0,2),
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(1,0),
      new Square(1,1),
      new Square(1,2),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(0,1),
      new Square(0,2),
      new Square(1,1),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(1,0),
      new Square(0,1),
      new Square(0,2),
      new Square(1,1),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(2,0),
      new Square(0,1),
      new Square(0,2),
      new Square(1,1),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(3,0),
      new Square(0,1),
      new Square(0,2),
      new Square(1,1),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(2,0),
      new Square(0,1),
      new Square(1,2),
      new Square(1,1),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(1,0),
      new Square(0,1),
      new Square(1,2),
      new Square(1,1),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(1,0),
      new Square(0,1),
      new Square(1,2),
      new Square(1,1),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(1,0),
      new Square(0,1),
      new Square(1,1),
      new Square(2,0),
      new Square(3,0),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(0,1),
      new Square(1,1),
      new Square(2,1),
      new Square(2,0),
      new Square(3,0),
      new Square(4,0)
    }),
    new Piece(new Square[] {
      new Square(0,1),
      new Square(1,1),
      new Square(2,1),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(1,0),
      new Square(2,0),
      new Square(0,1),
      new Square(1,1),
      new Square(2,1)
    }),
    new Piece(new Square[] {
      new Square(0,2),
      new Square(1,0),
      new Square(1,1),
      new Square(1,2),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(0,1),
      new Square(0,2),
      new Square(1,1),
      new Square(1,2),
      new Square(2,1)
    }),
    new Piece(new Square[] {
      new Square(0,2),
      new Square(1,1),
      new Square(1,2),
      new Square(2,0),
      new Square(2,1),
      new Square(3,1)
    }),
    new Piece(new Square[] {
      new Square(0,2),
      new Square(1,1),
      new Square(1,2),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,2),
      new Square(0,1),
      new Square(1,1),
      new Square(1,0),
      new Square(2,0),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(0,1),
      new Square(0,2),
      new Square(1,0),
      new Square(1,2),
      new Square(2,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(0,2),
      new Square(1,0),
      new Square(1,1),
      new Square(1,2),
      new Square(2,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(0,2),
      new Square(1,0),
      new Square(1,1),
      new Square(1,2),
      new Square(2,1)
    }),
    new Piece(new Square[] {
      new Square(0,1),
      new Square(0,2),
      new Square(1,1),
      new Square(2,0),
      new Square(2,1),
      new Square(3,0)
    }),
    new Piece(new Square[] {
      new Square(0,0),
      new Square(1,0),
      new Square(1,1),
      new Square(2,0),
      new Square(2,1),
      new Square(2,2)
    }),
    new Piece(new Square[] {
      new Square(0,1),
      new Square(1,0),
      new Square(1,1),
      new Square(1,2),
      new Square(2,0),
      new Square(2,1)
    }),
    new Piece(new Square[] {
      new Square(0,2),
      new Square(1,0),
      new Square(1,1),
      new Square(1,2),
      new Square(2,0),
      new Square(2,1)
    }),
    new Piece(new Square[] {
      new Square(0,2),
      new Square(1,2),
      new Square(1,1),
      new Square(2,1),
      new Square(2,0),
      new Square(3,0)
    }),
  };
}
