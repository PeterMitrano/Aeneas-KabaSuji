package aeneas.views;

import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.effects.JFXDepthManager;

import aeneas.controllers.IMove;
import aeneas.controllers.SetMovesMove;
import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.models.ReleaseLevel;
import aeneas.models.ReleaseNumber;
import aeneas.models.Square;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class ReleaseWidgetView extends LevelWidgetView {

  public static final RadioButton button = new RadioButton("Release");

  Spinner<Integer> movesSelect;
  private ReleaseLevel level;
  private boolean isUserInput = true;
  private Model model;

  public ReleaseWidgetView(ReleaseLevel levelModel, Model model) {
    super(levelModel);
    this.model = model;

    movesSelect = new Spinner<Integer>(1, 20, 10);
    Label movesLabel = new Label("Moves");

    Label releaseNumLabel = new Label("5");
    releaseNumLabel.setTextAlignment(TextAlignment.CENTER);
    releaseNumLabel.setPadding(new Insets(8,8,8,8));
    releaseNumLabel.setBackground(new Background(
          new BackgroundFill(Color.WHITE,
            new CornerRadii(2, false),
            new Insets(0,0,0,0))));
    JFXDepthManager.setDepth(releaseNumLabel,1);

    FontAwesomeIconView upArrowGlyph = new FontAwesomeIconView();
    upArrowGlyph.setGlyphName("ARROW_UP");
    upArrowGlyph.setGlyphSize(8);

    FontAwesomeIconView downArrowGlyph = new FontAwesomeIconView();
    downArrowGlyph.setGlyphName("ARROW_DOWN");
    downArrowGlyph.setGlyphSize(8);

    Button upReleaseNumButton = new Button();
    upReleaseNumButton.setPrefSize(15,5);
    upReleaseNumButton.setGraphic(upArrowGlyph);
    upReleaseNumButton.setPadding(new Insets(0,0,0,0));
    upReleaseNumButton.setStyle("-fx-background-color:WHITE");
    JFXDepthManager.setDepth(upReleaseNumButton,1);
    upReleaseNumButton.setOnMouseClicked((e) -> {
      Integer i = Integer.parseInt(releaseNumLabel.getText());
      if (i < 10){
        releaseNumLabel.setText(String.valueOf(i+1));
      }
    });

    Button downReleaseNumButton = new Button();
    downReleaseNumButton.setPrefSize(15,5);
    downReleaseNumButton.setGraphic(downArrowGlyph);
    downReleaseNumButton.setPadding(new Insets(0,0,0,0));
    downReleaseNumButton.setStyle("-fx-background-color:WHITE");
    JFXDepthManager.setDepth(downReleaseNumButton,1);
    downReleaseNumButton.setOnMouseClicked((e) -> {
      Integer i = Integer.parseInt(releaseNumLabel.getText());
      if (i > 0) {
        releaseNumLabel.setText(String.valueOf(i-1));
      }
    });

    movesSelect.setPrefWidth(70);
    movesSelect.setEditable(true);
    movesSelect.getValueFactory().setValue(levelModel.getAllowedMoves());
    movesSelect.valueProperty().addListener((observer, old_value, new_value) -> {
      if(!isUserInput) return;
      IMove move = new SetMovesMove(level, new_value);
      if(move.execute()){
        level.addNewMove(move);
      }
    });

    VBox box = new VBox();
    box.setSpacing(4);

    HBox movesBox = new HBox();
    movesBox.setSpacing(5);
    movesBox.setAlignment(Pos.CENTER_LEFT);
    movesBox.getChildren().add(movesLabel);
    movesBox.getChildren().add(movesSelect);

    JFXColorPicker colorSelect = new JFXColorPicker();
    colorSelect.prefWidth(100);

    VBox arrowBox = new VBox();
    arrowBox.setSpacing(2);
    arrowBox.setAlignment(Pos.CENTER_LEFT);
    arrowBox.getChildren().addAll(upReleaseNumButton, downReleaseNumButton);

    HBox releaseNumBox = new HBox();
    releaseNumBox.setAlignment(Pos.CENTER_LEFT);
    releaseNumBox.setSpacing(2);
    releaseNumBox.getChildren().add(releaseNumLabel);
    releaseNumBox.getChildren().add(arrowBox);

    box.getChildren().add(movesBox);
    box.getChildren().add(colorSelect);
    box.getChildren().add(releaseNumBox);

    panel.getChildren().add(box);

    button.setUserData(this);

    colorSelect.valueProperty().addListener((observer, old_color, new_color) -> {
      releaseNumLabel.setBackground(new Background(
            new BackgroundFill(new_color,
              new CornerRadii(2, false),
              new Insets(0,0,0,0))));
    });

    releaseNumLabel.setOnDragDetected((MouseEvent event) -> {
      Dragboard db = releaseNumLabel.startDragAndDrop(TransferMode.MOVE);
      ClipboardContent content = new ClipboardContent();
      Integer num = Integer.parseInt(releaseNumLabel.getText());
      ReleaseNumber releaseNum = new ReleaseNumber(-1, -1, colorSelect.getValue(), num);
      content.put(ReleaseNumber.dataFormat, releaseNum);
      content.putString();
      db.setContent(content);

      SnapshotParameters snapshotParameters = new SnapshotParameters();
      snapshotParameters.setFill(Color.TRANSPARENT); // i3 doesn't handle this

      Square square = new Square(-1, -1, releaseNum);
      SquareView releaseNumView = new SquareView(BoardView.SQUARE_SIZE, square);

      Image snapshotImage = releaseNumView.snapshot(snapshotParameters, null);
      db.setDragView(snapshotImage);

      event.consume();
    });

  }

  @Override
  public RadioButton getButton() {
    return ReleaseWidgetView.button;
  }

  @Override
  public void updateValues(){
    isUserInput = false;
    getButton().setSelected(true);
    movesSelect.getValueFactory().setValue(level.getAllowedMoves());
    isUserInput = true;
  }

  @Override
  public Level resetLevelModel(Level level) {
    if (level instanceof ReleaseLevel) {
      this.level = (ReleaseLevel) level;
      return level;
    }
    this.level = new ReleaseLevel(level);
    movesSelect.valueProperty().addListener((observer, old_value, new_value) -> {
      if(!isUserInput) return;
      IMove move = new SetMovesMove(this.level, new_value);
      if(move.execute()){
        level.addNewMove(move);
      }
    });
    updateValues();
    return this.level;
  }

}
