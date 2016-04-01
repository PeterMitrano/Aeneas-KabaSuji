package kabasuji.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import kabasuji.models.Model;

public class ViewAchievementsView extends BorderPane implements Initializable {

  ViewAchievementsView(Model model) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/ui/ViewAchievements.fxml"));
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

}
