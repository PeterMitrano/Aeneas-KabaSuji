package aeneas.models;

import java.util.ArrayList;

/**
 * A bullpen is a list of pieces available to the player.
 *
 * @author Logan
 * @author Joseph Martin
 * @author jbkuszmaul
 */
public class Bullpen implements java.io.Serializable {
  /**
   * @return the logic
   */
  public BullpenLogic getLogic() {
    return logic;
  }

  /**
   * Set the logic.
   * @param logic the logic to use for this bullpen
   */
  public void setLogic(BullpenLogic logic) { this.logic = logic; }

  /**
   * Represents the logic of a bullpen.
   * This determines what kind of actions/behavior
   * are valid for a particular Bullpen
   */
  public static class BullpenLogic implements java.io.Serializable {
    private boolean canAddNewPiece;
    private boolean isRandom;

    /**
     * Create a new BullpenLogic for editing a level
     * @return A BullpenLogic to be used when editing a level
     */
    public static BullpenLogic editorLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = true;
      b.isRandom = false;
      return b;
    }
    
    /**
     * Create a new BullpenLogic for playing a puzzle level
     * @return A BullpenLogic to be used when playing a puzzle level
     */
    public static BullpenLogic puzzleLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = false;
      b.isRandom = false;
      return b;
    }

    /**
     * Create a new BullpenLogic for playing a lightning level
     * @return A BullpenLogic to be used when playing a lightning level
     */
    public static BullpenLogic lightningLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = false;
      b.isRandom = true;
      return b;
    }

    /**
     * Create a new BullpenLogic for playing a release level
     * @return A BullpenLogic to be used when playing a release level
     */
    public static BullpenLogic releaseLogic() {
      BullpenLogic b = new BullpenLogic();
      b.canAddNewPiece = false;
      b.isRandom = false;
      return b;
    }

    /**
     * Check if pieces can be added to a bullpen
     * @return True if pieces can be added to the bullpen, false otherwise
     */
    public boolean isCanAddNewPiece() {
      return canAddNewPiece;
    }

    /**
     * Check if a piece removed from the bullpen should be replaced by a new, random piece
     * @return True if removed pieces should be replaced, false otherwise.
     */
    public boolean isRandom() {
      return isRandom;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof BullpenLogic) {
        BullpenLogic other = (BullpenLogic)obj;
        return this.canAddNewPiece == other.canAddNewPiece &&
               this.isRandom == other.isRandom;
      }
      return false;
    }
  }

  ArrayList<Piece> pieces;
  BullpenLogic logic;

  /**
   * Construct a bullpen with an empty list of pieces.
   * @param logic the type of logic
   */
  public Bullpen(BullpenLogic logic) {
    this.pieces = new ArrayList<Piece>();
    this.logic = logic;
  }

  /**
   * Construct a bullpen with the given list of pieces
   * @param pieces The initial list of pieces for the bullpen to contain.
   * @param logic the type of logic
   */
  public Bullpen(BullpenLogic logic, ArrayList<Piece> pieces) {
    this.pieces = pieces;
    this.logic = logic;
  }

  /**
   * Adds a piece to he bullpen
   * @param piece the piece to add
   */
  public void addPiece(Piece piece) {
    this.pieces.add(piece);
  }

  /**
   * Removes the given piece from the bullpen, if present.
   * @param piece the piece to remove.
   * @return true if piece was found and removed, false otherwise.
   */
  public boolean removePiece(Piece piece) {
    return this.pieces.remove(piece);
  }

  /**
   * @return the pieces
   */
  public ArrayList<Piece> getPieces() {
    return pieces;
  }

  /**
   * Create a copy of the bullpen.
   */
  @Override
  public Object clone() {
    Bullpen newBullpen = new Bullpen(this.logic);
    for (Piece piece: this.pieces) {
      newBullpen.pieces.add(piece.clone());
    }
    return newBullpen;
  }
}
