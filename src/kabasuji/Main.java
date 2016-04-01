package kabasuji;

import java.io.IOException;

import com.jfoenix.controls.JFXDecorator;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

  @FXML
  private StackPane root;

  public void start(Stage stage) {
    try {
      root = FXMLLoader.load(getClass().getResource("/resources/fxml/Main.fxml"));

      Scene scene = new Scene(new JFXDecorator(stage, root), 800, 800);

      scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
      scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-design.css").toExternalForm());
      scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());

      stage.setMinWidth(700);
      stage.setMinHeight(700);
      stage.setScene(scene);
      stage.show();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    launch(args);
  }
}
