package kabasuji.views;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
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
  private JFXButton back;

  @FXML
  private WelcomeView welcomeView;

  @FXML
  private ViewAchievementsView viewAchievementsView;

  private Stack<Pane> paneStack;
  private Pane currentPane;

  public MainView() {
    paneStack = new Stack<Pane>();
  }

  public void switchToWelcomeView() {
    currentPane = welcomeView;
    paneStack.push(currentPane);
    content.getChildren().clear();
    content.getChildren().add(welcomeView);
  }

  public void switchToViewAchievementsView() {
    currentPane = viewAchievementsView;
    paneStack.push(currentPane);
    content.getChildren().clear();
    content.getChildren().add(viewAchievementsView);
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

    back.setOnMouseClicked((e) -> {
      // unless we're out of places to go back, go at the last pane we
      // were on
      if (!paneStack.isEmpty()) {
        Pane lastPane = paneStack.pop();
        content.getChildren().clear();
        content.getChildren().add(lastPane);
        paneStack.push(currentPane);
      }
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
