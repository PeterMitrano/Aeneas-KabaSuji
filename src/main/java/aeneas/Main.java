package aeneas;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jfoenix.controls.JFXDecorator;

import aeneas.views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  public void start(Stage stage) {
    MainView mainView = new MainView(stage);
    Scene scene = new Scene(new JFXDecorator(stage, mainView.root), 800, 800);
    scene.getStylesheets().add(getClass().getResource("kabasuji.css").toExternalForm());
    stage.setMinWidth(700);
    stage.setMinHeight(700);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    JFrame x = new JFrame("HelloWorldSwing");
    x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel label = new JLabel("Aeneas Kabasuji, made by Peter Mitrano, Joesph Martin, "
        + "James Kuszmaul, Logan Tutt, and Garrison Hefter");
    x.getContentPane().add(label);
    x.setLocation(500, 500);
    x.setSize(500, 300);
    x.setVisible(true);
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
    }
    x.setVisible(false);
    x.dispose();
    launch(args);
  }
}
