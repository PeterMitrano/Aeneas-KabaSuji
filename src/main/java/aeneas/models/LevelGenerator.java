package aeneas.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import aeneas.models.Bullpen.BullpenLogic;

public class LevelGenerator {

  private static int levelNumber = 1;

  public static void main(String[] args) {
    File file = new File("build/levels/default/");
    file.mkdirs();

    for (Level l : generateDefaultLevels()) {
      saveNewLevel(l);
    }
  }

  public static ArrayList<Level> generateDefaultLevels() {
    ArrayList<Level> levels = new ArrayList<Level>();

    levels.add(newPuzzle(30, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }));
    levels.add(newLightning(90, new int[] { 8, 6, 4, 11, 15 }));
    levels.add(newRelease(16, new int[] { 0, 1, 2, 3, 2 }));

    levels.add(newPuzzle(30,
        new int[] { 4, 0, 12, 2, 30, 10, 23, 5, 14, 22, 11, 6, 7, 24, 5, 10, 12,
            15, 1, 21, 2, 3, 4, 5, 8, 7, 28, 29, 10, 34, 12, 13, 14, 15, 12, 14, 27,
            2, 5 }));
    levels.add(newLightning(85, new int[] { 2, 0, 1, 10, 14 }));
    levels.add(newRelease(12, new int[] { 4, 2, 12, 2, 2 }));

    levels
        .add(newPuzzle(30,
            new int[] { 10, 11, 2, 14, 22, 21, 0, 2, 6, 3, 4, 27, 5, 26, 7, 12, 8,
                1, 9, 14, 1, 4, 0, 6, 25, 2, 0, 12, 6, 4, 12, 4, 23, 24, 12, 12,
                12, 31, 34}));
    levels.add(newLightning(80, new int[] { 1, 6, 4, 11, 13 }));
    levels.add(newRelease(12, new int[] { 10, 11, 2, 14, 2 }));

    levels.add(newPuzzle(25, new int[] { 4, 13, 7, 4, 8 }));
    levels.add(newLightning(70, new int[] { 0, 3, 3, 11, 12 }));
    levels.add(newRelease(10, new int[] { 4, 13, 7, 4, 8 }));

    levels.add(newPuzzle(25,
        new int[] { 4, 2, 12, 2, 2, 10, 3, 5, 14, 12, 11, 6, 7, 5, 5, 10, 12,
            15, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 12, 14, 3,
            2, 5 }));
    levels.add(newLightning(60, new int[] { 1, 4, 1, 11, 13 }));
    levels.add(newRelease(10, new int[] { 3, 6, 5, 4, 9 }));

    return levels;
  }

  private static ReleaseLevel newRelease(int moves, int[] pieceIndeces) {
    Bullpen bullpen = new Bullpen(BullpenLogic.releaseLogic());
    addPieces(bullpen, pieceIndeces);
    ReleaseLevel l = new ReleaseLevel(bullpen);
    l.setAllowedMoves(moves);
    return l;
  }

  private static LightningLevel newLightning(int time, int[] pieceIndeces) {
    Bullpen bullpen = new Bullpen(BullpenLogic.lightningLogic());
    addPieces(bullpen, pieceIndeces);
    LightningLevel l = new LightningLevel(bullpen, time);
    return l;
  }

  private static PuzzleLevel newPuzzle(int moves, int[] pieceIndeces) {
    Bullpen bullpen = new Bullpen(BullpenLogic.puzzleLogic());
    addPieces(bullpen, pieceIndeces);
    PuzzleLevel l = new PuzzleLevel(bullpen, new PuzzleBoard());
    l.setAllowedMoves(moves);
    return l;
  }

  private static void addPieces(Bullpen bullpen, int[] pieceIndeces){
    Piece[] pieces = PieceFactory.getPieces();
    for (int i : pieceIndeces) {
      bullpen.addPiece(pieces[i].clone());
    }
  }

  private static void saveNewLevel(Level l) {
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
