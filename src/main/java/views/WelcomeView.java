package main.java.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import main.java.models.Model;

public class WelcomeView extends VBox implements Initializable{

	@FXML
	private JFXButton playSelectLevelButton;

  @FXML
	private JFXButton buildSelectLevelButton;

	@FXML
	private JFXButton viewAchievementsButton;

  private MainView parentView;

  public WelcomeView(MainView parentView, Model model){

    this.parentView = parentView;

    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/fxml/Welcome.fxml"));
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
		playSelectLevelButton.setOnMouseClicked((e) -> {
      parentView.switchToPlaySelectLevelView();
		});

		viewAchievementsButton.setOnMouseClicked((e) -> {
      parentView.switchToViewAchievementsView();
		});

		buildSelectLevelButton.setOnMouseClicked((e) -> {
      parentView.switchToBuildSelectLevelView();
		});

	}
}
