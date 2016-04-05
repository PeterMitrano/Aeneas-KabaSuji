package kabasuji.views;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

import kabasuji.models.Model;

public class BuildLevelView extends BorderPane implements Initializable {

  @FXML
  private JFXListView bullpenListView;

  @FXML
  private Label levelLabel;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  BuildLevelView(Model model) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/BuildLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    JFXDepthManager.setDepth(bullpenListView, 1);

    // add a piece to the bullpen as an example
    AnchorPane piecePane = new AnchorPane();
    piecePane.setPrefSize(96,96);

    Rectangle square1 = RectangleBuilder.create().width(16).height(16).x(0).y(0).fill(Color.BLUE).build();
    Rectangle square2 = RectangleBuilder.create().width(16).height(16).x(16).y(0).fill(Color.BLUE).build();
    Rectangle square3 = RectangleBuilder.create().width(16).height(16).x(16).y(16).fill(Color.BLUE).build();
    Rectangle square4 = RectangleBuilder.create().width(16).height(16).x(0).y(16).fill(Color.BLUE).build();
    Rectangle square5 = RectangleBuilder.create().width(16).height(16).x(0).y(32).fill(Color.BLUE).build();
    Rectangle square6 = RectangleBuilder.create().width(16).height(16).x(32).y(16).fill(Color.BLUE).build();

    piecePane.getChildren().add(square1);
    piecePane.getChildren().add(square2);
    piecePane.getChildren().add(square3);
    piecePane.getChildren().add(square4);
    piecePane.getChildren().add(square5);
    piecePane.getChildren().add(square6);

    List<AnchorPane> values = Arrays.asList(piecePane);
    bullpenListView.setItems(FXCollections.observableList(values));
  }

}
