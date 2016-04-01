package kabasuji.views;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class BuildSelectLevelView implements Initializable {

  @FXML
  private JFXListView fileList;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    fileList.setOnMouseClicked((e) -> {
      System.out.println("clicked " + fileList.getSelectionModel().getSelectedItem());
    });

  }

}
