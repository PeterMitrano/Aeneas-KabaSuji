package aeneas.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;

/**
 * 
 * @author Joseph Martin
 */
public class LevelIndex {
  HashMap<Integer, Level> levels;

  LevelIndex() {
    levels = new HashMap<>();
    reindex();
  }

  public void reindex() {
    levels.clear();

    Path level_dir = null;
    try {
      level_dir = Paths.get(getClass().getResource("levels").toURI());
    } catch (URISyntaxException e1) {
      e1.printStackTrace();
      return;
    }

    if(!Files.exists(level_dir)) {
      System.err.println("Error loading levels. Directory '"+level_dir+"' does not exist.");
      return;
    }

    try {
      Files.list(level_dir).filter(file -> file.getFileName().toString().endsWith(".ksb")).forEach((file) -> {
        ObjectInputStream ois = null;
        try {
          ois = new ObjectInputStream(new FileInputStream(file.toFile()));
        } catch (IOException e) {
          e.printStackTrace();
          System.err.println("Error reading file '"+file+"'");
        }

        try {
          int n = Integer.parseInt(file.getFileName().toString().replaceFirst("[.].*$", ""));
          Level l = (Level)ois.readObject();
          l.levelNumber = n;
          levels.put(l.levelNumber, l);
        } catch (NumberFormatException e) {
          // Do something here to load custom levels
        } catch (ClassNotFoundException e) {
          // Improperly formatted file. Ignore it and move on
          e.printStackTrace();
          System.err.println("Error reading from file '"+file+"'");
        } catch (IOException e) {
          // Something went wrong reading the file. Ignore this file and move on.
          e.printStackTrace();
          System.err.println("Error reading from file '"+file+"'");
        }

        // Try to close the stream
        if(ois != null) {
          try {
            ois.close();
          } catch (IOException e) {
            // Oh well. We tried.
          }
        }
      });
    } catch (NotDirectoryException e) {
      System.err.println("Error loading levels. '"+level_dir+"' is not a directory");
    } catch (IOException e) {
      System.err.println("Error reading from directory '"+level_dir+"'");
    }
  }

  Collection<Level> getLevels() {
    return levels.values();
  }
  
  Level getLevel(int i) {
    return levels.get(i);
  }
}
