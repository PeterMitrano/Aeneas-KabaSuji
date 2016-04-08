package main.java;

import com.jfoenix.controls.JFXDecorator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.views.MainView;

public class Main extends Application {

  public void start(Stage stage) {
    MainView mainView = new MainView(stage);

    Scene scene = new Scene(new JFXDecorator(stage, mainView.root), 800, 800);

    scene.getStylesheets().add(getClass().getResource("/main/resources/css/kabasuji.css").toExternalForm());

    stage.setMinWidth(700);
    stage.setMinHeight(700);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
