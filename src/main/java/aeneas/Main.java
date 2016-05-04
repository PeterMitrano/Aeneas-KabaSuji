package aeneas;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jfoenix.controls.JFXDecorator;

import aeneas.views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Joseph Martin
 * @author Garrison
 */
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
    //best splash screen ever
    JFrame frame = new JFrame("HelloWorldSwing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel label = new JLabel("<html>Aeneas Kabasuji, made by Peter Mitrano, Joesph Martin,<br>"
        + "James Kuszmaul, Logan Tutt, and Garrison Hefter</html>");
    frame.getContentPane().add(label);
    frame.setLocation(500, 500);
    frame.setSize(300, 300);
    frame.setVisible(true);
    try {
      Thread.sleep(400);
    } catch (InterruptedException e) {
    }
    frame.setVisible(false);
    frame.dispose();

    //start the legitimate application!
    launch(args);
  }

  /**
   * checks if the program is on a mac to prevent weird drag behavior
   * @return true if is on mac
   */
  public static boolean isRunningOnMac() {
    String os = System.getProperty("os.name").toLowerCase();
    return os.contains("darwin")  || os.contains("mac");
  }
}
