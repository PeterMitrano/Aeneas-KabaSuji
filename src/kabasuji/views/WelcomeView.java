package kabasuji.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class WelcomeView extends VBox implements Initializable{

	@FXML
	private JFXButton playSelectLevelButton;

	@FXML
	private JFXButton buildSelectLevelButton;

	@FXML
	private JFXButton viewAchievementsButton;

  MainView mainView;


  public WelcomeView(MainView mainView){

    this.mainView = mainView;

    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/ui/Welcome.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		playSelectLevelButton.setOnMouseClicked((e) -> {
			System.out.println("play select level");
		});

		viewAchievementsButton.setOnMouseClicked((e) -> {
      //change the thing!
      //transitionController.transition(this,ViewAchievementsView.class);
		});

		buildSelectLevelButton.setOnMouseClicked((e) -> {
			System.out.println("build select level");
		});
	}
}
