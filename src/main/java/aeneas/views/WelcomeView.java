package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import aeneas.models.Model;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * Starting view of the application, used to navigate to the build 
 * select level, play select level screen, or achievements screen.
 * 
 * @author Joseph martin
 */
public class WelcomeView extends VBox implements Initializable, RefreshListener {

	@FXML
	private JFXButton playSelectLevelButton;

  @FXML
	private JFXButton buildSelectLevelButton;

	@FXML
	private JFXButton viewAchievementsButton;

  private MainView mainView;

  /**
   * Creates a new WelcomeView
   * @param mainView The top level view.
   */
  public WelcomeView(MainView mainView){

    this.mainView = mainView;

    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

    //should there be a controller for this? It seems a bit excessive.
		viewAchievementsButton.setOnMouseClicked((e) -> {
      mainView.switchToViewAchievementsView();
    });

		playSelectLevelButton.setOnMouseClicked((e) -> {
      mainView.switchToPlaySelectLevelView();
    });

		buildSelectLevelButton.setOnMouseClicked((e) -> {
      mainView.switchToBuildSelectLevelView();
    });

	}

  @Override
  public void refresh() {
  }
}
