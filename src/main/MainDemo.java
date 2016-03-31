package main;

import com.jfoenix.controls.JFXDecorator;

import controllers.MainController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDemo extends Application {

	@FXMLViewFlowContext private ViewFlowContext flowContext;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {

		Flow flow = new Flow(MainController.class);
		DefaultFlowContainer container = new DefaultFlowContainer();
		flowContext = new ViewFlowContext();
		flowContext.register("Stage", stage);
		flow.createHandler(flowContext).start(container);
		
		Scene scene = new Scene(new JFXDecorator(stage, container.getView()), 800, 800);
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());

		stage.setMinWidth(700);
		stage.setMinHeight(700);
		stage.setScene(scene);
		stage.show();

	}

}