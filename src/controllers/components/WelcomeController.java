package controllers.components;

import javax.annotation.PostConstruct;

import com.jfoenix.controls.JFXButton;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

@FXMLController(value = "/resources/fxml/ui/Welcome.fxml", title = "Welcome To KabaSuji")
public class WelcomeController {

	@FXMLViewFlowContext
	private ViewFlowContext context;

	@FXML
	private JFXButton playSelectLevelButton;
	private JFXButton buildSelectLevelButton;
	private JFXButton achievementsButton;

	@PostConstruct
	public void init() throws FlowException, VetoException {
		if (((Pane) context.getRegisteredObject("ContentPane")).getChildren().size() > 0)
			Platform.runLater(() -> ((Pane) ((Pane) context.getRegisteredObject("ContentPane")).getChildren().get(0))
					.getChildren().remove(1));

		playSelectLevelButton.setOnMouseClicked((e) -> {
			System.out.println("play select level");
			
		});
	}

}
