package aeneas.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXListView;

import aeneas.controllers.AddPieceMove;
import aeneas.controllers.IMove;
import aeneas.controllers.SaveLevelController;
import aeneas.controllers.UndoRedoController;
import aeneas.models.Level;
import aeneas.models.Model;
import aeneas.models.Piece;
import aeneas.models.PieceFactory;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BuildLevelView extends StackPane implements Initializable {

  private static final int PIECE_PICKER_SQUARE_SIZE = 12;

  @FXML
  private JFXDialog piecePickerDialog;

  @FXML
  private FlowPane piecesPane;

  @FXML
  private JFXListView<Pane> bullpenListView;

  @FXML
  private Label levelLabel;

  @FXML
  private JFXButton addPiece;

  @FXML
  private FontAwesomeIconView levelTypeIcon;

  @FXML
  private VBox bullpenBox;

  @FXML
  private VBox centerBox;

  @FXML
  private JFXDatePicker timeSetter;

  @FXML
  private JFXButton saveButton;
  
  @FXML
  private JFXButton undoButton;
  
  @FXML
  private JFXButton redoButton;

  BoardView boardView;
  Model model;
  Level levelModel;
  MainView mainView;
  BullpenView bullpenView;

  BuildLevelView(MainView mainView, Level levelModel, Model model) {
    this.model = model;
    this.levelModel = levelModel;
    this.mainView = mainView;
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("BuildLevel.fxml"));
      loader.setRoot(this);
      loader.setController(this);
      loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void refreshAll(){
    //boardView.refresh;
    bullpenView.refresh(model, levelModel.getBullpen());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.bullpenView = new BullpenView(bullpenBox, (Pane) this);

    this.boardView = new BoardView(levelModel.getBoard());
    VBox.setMargin(boardView, new Insets(10, 10, 10, 10));
    centerBox.setAlignment(Pos.TOP_RIGHT);
    centerBox.getChildren().add(boardView);

    saveButton.setOnMouseClicked(
        new SaveLevelController(mainView, levelModel));

    piecePickerDialog.setTransitionType(DialogTransition.CENTER);

    addPiece.setOnMouseClicked((e) -> {
      piecePickerDialog.show(this);
      piecesPane.getChildren().clear();

      for (Piece pieceModel : PieceFactory.getPieces()) {
        PieceView pView = new PieceView((Pane) this, pieceModel, model, PIECE_PICKER_SQUARE_SIZE);
        piecesPane.getChildren().add(pView);

        pView.setOnMouseClicked((click) -> {
          IMove move = new AddPieceMove(levelModel.getBullpen(), pieceModel.clone());
          if (move.execute()){
            model.addNewMove(move);
            bullpenView.refresh(model, levelModel.getBullpen());
          }
        });
      }
    });
    UndoRedoController undoController = new UndoRedoController(this, model);
    mainView.setOnKeyPressed(undoController );
    undoButton.setOnMouseClicked((e)-> {
      undoController.undoMove();
    });
    redoButton.setOnMouseClicked((e)-> {
      undoController.redoMove();
    });
    
  }
}
