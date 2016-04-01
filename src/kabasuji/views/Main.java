package kabasuji.views;

import java.io.IOException;

import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	@FXML
	private StackPane root;

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

	public void start(Stage stage) {
		try {
			root = FXMLLoader.load(getClass().getResource("/resources/fxml/Main.fxml"));
			
			// init Popup
			toolbarPopup = (JFXPopup) root.lookup("#toolbarPopup");
			optionsRippler = (JFXRippler) root.lookup("#optionsRippler");
			optionsBurger = (StackPane) root.lookup("#optionsBurger");
			
			toolbarPopup.setPopupContainer(root);
			toolbarPopup.setSource(optionsRippler);			
			optionsBurger.setOnMouseClicked((e) -> {
				toolbarPopup.show(PopupVPosition.TOP, PopupHPosition.RIGHT, -12, 15);
			});
			
			Scene scene = new Scene(new JFXDecorator(stage, root), 800, 800);

			scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-design.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());

			stage.setMinWidth(700);
			stage.setMinHeight(700);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
