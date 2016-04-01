package kabasuji.views;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainView implements Initializable {

  @FXML
  private StackPane root;

  @FXML
  private StackPane content;

  @FXML
  private StackPane optionsBurger;

  @FXML
  private JFXRippler optionsRippler;

  @FXML
  private Label about;

  @FXML
  private Label help;

  @FXML
  private JFXPopup toolbarPopup;

  @FXML
  private WelcomeView welcomeView;

  @FXML
  private ViewAchievementsView viewAchievementsView;

  private void switchToWelcomeView() {
    content.getChildren().clear();
    content.getChildren().add(welcomeView);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    welcomeView = new WelcomeView(this);

    // init Popup
    toolbarPopup.setPopupContainer(root);
    toolbarPopup.setSource(optionsRippler);
    optionsBurger.setOnMouseClicked((e) -> {
      toolbarPopup.show(PopupVPosition.TOP, PopupHPosition.RIGHT, -12, 5);
    });

    help.setOnMouseClicked((e) -> {
      System.out.println("Help");
    });

    about.setOnMouseClicked((e) -> {
      System.out.println("About");
    });

    switchToWelcomeView();
  }
}
