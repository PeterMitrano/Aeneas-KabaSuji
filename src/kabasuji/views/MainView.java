package kabasuji.views;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

public class MainView implements Initializable {

  @FXML
  private StackPane content;

  @FXML
  private StackPane optionsBurger;
  @FXML
  private JFXRippler optionsRippler;

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

    switchToWelcomeView();
  }
}
