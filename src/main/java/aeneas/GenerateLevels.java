package aeneas;

import java.io.File;
import java.io.IOException;

import aeneas.models.Bullpen;
import aeneas.models.Bullpen.BullpenLogic;
import aeneas.models.Level;
import aeneas.models.LightningLevel;
import aeneas.models.Piece;
import aeneas.models.PieceFactory;
import aeneas.models.PuzzleLevel;
import aeneas.models.ReleaseLevel;

public class GenerateLevels {

  private static int levelNumber = 1;

  public static void main(String[] args) {
    File file = new File("build/levels/default/");
    file.mkdirs();

    saveNewLevel(newPuzzle(16, new int[]{0,1,2,3,2}));
    saveNewLevel(newLightning(60, new int[]{8,6,4,11,15}));
    saveNewLevel(newRelease(16, new int[]{0,1,2,3,2}));

    saveNewLevel(newPuzzle(12, new int[]{4,2,12,2,2}));
    saveNewLevel(newLightning(50, new int[]{2,0,1,10,14}));
    saveNewLevel(newRelease(12, new int[]{4,2,12,2,2}));

    saveNewLevel(newPuzzle(12, new int[]{10,11,2,14,2}));
    saveNewLevel(newLightning(40, new int[]{1,6,4,11,13}));
    saveNewLevel(newRelease(12, new int[]{10,11,2,14,2}));

    saveNewLevel(newPuzzle(10, new int[]{4,13,7,4,8}));
    saveNewLevel(newLightning(30, new int[]{0,3,3,11,12}));
    saveNewLevel(newRelease(10, new int[]{4,13,7,4,8}));

    saveNewLevel(newPuzzle(10, new int[]{3,6,5,4,9}));
    saveNewLevel(newLightning(20, new int[]{1,4,1,11,13}));
    saveNewLevel(newRelease(10, new int[]{3,6,5,4,9}));
  }

  private static ReleaseLevel newRelease(int moves, int[] pieceIndeces) {
    Piece[] pieces = PieceFactory.getPieces();
    Bullpen bullpen = new Bullpen(BullpenLogic.releaseLogic());
    for (int i : pieceIndeces){
      bullpen.addPiece(pieces[i]);
    }
    ReleaseLevel l = new ReleaseLevel(bullpen);
    l.setAllowedMoves(moves);
    return l;
  }

  private static LightningLevel newLightning(int time, int[] pieceIndeces) {
    Piece[] pieces = PieceFactory.getPieces();
    Bullpen bullpen = new Bullpen(BullpenLogic.lightningLogic());
    for (int i : pieceIndeces){
      bullpen.addPiece(pieces[i]);
    }
    LightningLevel l = new LightningLevel(bullpen, time);
    return l;
  }

  private static PuzzleLevel newPuzzle(int moves, int[] pieceIndeces) {
    Piece[] pieces = PieceFactory.getPieces();
    Bullpen bullpen = new Bullpen(BullpenLogic.puzzleLogic());
    for (int i : pieceIndeces){
      bullpen.addPiece(pieces[i]);
    }
    PuzzleLevel l = new PuzzleLevel(bullpen);
    l.setAllowedMoves(moves);
    return l;
  }

  private static void saveNewLevel(Level l){
    String path = "build/levels/default/" + levelNumber + ".ksb";
    File file = new File(path);
    levelNumber++;
    try {
      l.save(file);
      System.out.println("wrote level: " + path);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
