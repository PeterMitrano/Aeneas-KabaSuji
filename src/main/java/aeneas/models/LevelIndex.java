package aeneas.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 *
 * @author Joseph Martin
 * @author jbkuszmaul
 */
public class LevelIndex {
  HashMap<Integer, Level> levels;

  public final Path defaultLevelPath;

  // Whether or not we should load the levels from the ~/.aeneas-kabasuji
  // directory. This is used for testing, when we don't want whatever weird
  // things are in the user's computer affecting the tests.
  private boolean loadUserLevels = true;

  LevelIndex() {
    levels = new HashMap<>();
    // TODO: Consider changing this path.
    defaultLevelPath = Paths.get(System.getProperty("user.home"), ".aeneas-kabasuji");
    reindex();
  }

  public void reindex() {
    levels.clear();

    ArrayList<Level> defaultLevels = LevelGenerator.generateDefaultLevels();
    for (int i = 0; i < defaultLevels.size(); i++) {
      Level l = defaultLevels.get(i);
      l.levelNumber = i+1;
      levels.put(i+1, l);
    }

    if (!loadUserLevels) return;

    if (!Files.exists(defaultLevelPath)) {
      try {
        Files.createDirectory(defaultLevelPath);
      } catch(IOException e) {
        System.err.println("Could not create default level directory '" + defaultLevelPath + "'");
        return;
      }

      System.out.println("Directory '" + defaultLevelPath + "' does not exist; it will be created.");
      return;
    }

    try {
      Stream<Path> files = Files.list(defaultLevelPath).filter(file -> file.getFileName().toString().endsWith(".kbs"));
      files.forEach((file) -> {
        ObjectInputStream ois = null;
        try {
          ois = new ObjectInputStream(new FileInputStream(file.toFile()));
        } catch (IOException e) {
          System.err.println("Error reading file '" + file + "'");
        }

        try {
          int n = Integer.parseInt(file.getFileName().toString().replaceFirst("[.].*$", ""));
          Level l = (Level) ois.readObject();
          l.levelNumber = n;
          levels.put(l.levelNumber, l);
        } catch (NumberFormatException e) {
          // Do something here to load custom levels
        } catch (ClassNotFoundException e) {
          // Improperly formatted file. Ignore it and move on
          e.printStackTrace();
          System.err.println("Error reading from file '" + file + "'");
        } catch (IOException e) {
          // Something went wrong reading the file. Ignore this file and move
          // on.
          e.printStackTrace();
          System.err.println("Error reading from file '" + file + "'");
        }

        // Try to close the stream
        if (ois != null) {
          try {
            ois.close();
          } catch (IOException e) {
            // Oh well. We tried.
          }
        }
      });
    } catch (NotDirectoryException e) {
      System.err.println("Error loading levels. '" + defaultLevelPath + "' is not a directory");
    } catch (IOException e) {
      System.err.println("Error reading from directory '" + defaultLevelPath + "'");
    }
  }

  Collection<Level> getLevels() {
    return levels.values();
  }

  Level getLevel(int i) {
    return levels.get(i);
  }

  public void setLoadUserLevels(boolean set) {
    this.loadUserLevels = set;
  }
}
