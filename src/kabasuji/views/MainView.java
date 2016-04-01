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
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import kabasuji.models.Model;

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

  private ViewAchievementsView viewAchievementsView;
  private WelcomeView welcomeView;
  private PlaySelectLevelView playSelectLevelView;
  private BuildSelectLevelView buildSelectLevelView;

  private Stack<Node> paneStack;

  public MainView() {
    paneStack = new Stack<Node>();
  }

  public void switchToWelcomeView() {
    paneStack.push(welcomeView);
    content.getChildren().clear();
    content.getChildren().add(welcomeView);
  }

  public void switchToViewAchievementsView() {
    paneStack.push(viewAchievementsView);
    content.getChildren().clear();
    content.getChildren().add(viewAchievementsView);
  }

  public void switchToBuildSelectLevelView() {
    paneStack.push(buildSelectLevelView);
    content.getChildren().clear();
    content.getChildren().add(buildSelectLevelView);
  }

  public void switchToPlaySelectLevelView() {
    paneStack.push(playSelectLevelView);
    content.getChildren().clear();
    content.getChildren().add(playSelectLevelView);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    welcomeView = new WelcomeView(this, new Model());

    playSelectLevelView= new PlaySelectLevelView(new Model());
    viewAchievementsView = new ViewAchievementsView(new Model());
    buildSelectLevelView= new BuildSelectLevelView(new Model());

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
    	  paneStack.pop();
        content.getChildren().clear();
        content.getChildren().add(paneStack.peek());
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
