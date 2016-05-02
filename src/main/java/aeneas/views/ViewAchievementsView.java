package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import aeneas.models.Model;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class ViewAchievementsView extends BorderPane implements Initializable, RefreshListener {

  ViewAchievementsView(Model model) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAchievements.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  @Override
  public void refresh() {
  }

}
