package aeneas.views;

import java.util.ArrayList;

public class LevelViewFactory {

  private static ArrayList<LevelView> levelViews = new ArrayList<LevelView>();

  public static void addView(LevelView view){
    levelViews.add(view);
  }

  public static ArrayList<LevelView> getViews(){
    return levelViews;
  }

}
