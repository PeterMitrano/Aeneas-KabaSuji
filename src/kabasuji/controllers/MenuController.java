package kabasuji.controllers;

import javax.annotation.PostConstruct;

import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MenuController {

	@FXML
	private StackPane root;
	@FXML
	private StackPane content;

	@FXML
	private StackPane optionsBurger;
	@FXML
	private JFXRippler optionsRippler;

	@FXML
	private JFXPopup toolbarPopup;


	@PostConstruct
	public void init() {
		// init Popup
		toolbarPopup.setPopupContainer(root);
		toolbarPopup.setSource(optionsRippler);
		optionsBurger.setOnMouseClicked((e) -> {
			toolbarPopup.show(PopupVPosition.TOP, PopupHPosition.RIGHT, -12, 15);
		});
		
		
		optionsBurger.setOnMouseClicked((e) -> {
			toolbarPopup.show(PopupVPosition.TOP, PopupHPosition.RIGHT, -12, 15);
		});

	}
}
