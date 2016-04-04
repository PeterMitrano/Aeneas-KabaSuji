package kabasuji.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import kabasuji.models.Model;

public class BuildSelectLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXListView fileList;

  private Model model;

  BuildSelectLevelView(Model model) {
    this.model = model;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/BuildSelectLevel.fxml"));
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
    fileList.setOnMouseClicked((e) -> {
      System.out.println("selected " + fileList.getSelectionModel().getSelectedItem());
    });

  }

}
