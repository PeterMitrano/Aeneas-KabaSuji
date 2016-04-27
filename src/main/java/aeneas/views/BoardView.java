package aeneas.views;

import aeneas.models.Board;
import aeneas.models.Piece;
import aeneas.models.PlacedPiece;
import aeneas.models.Square;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

/**
 * View class to display a board
 * 
 * @author Logan Tutt
 * @author Joseph Martin
 */
public class BoardView extends GridPane {

  /** Specifies how many pixels the squares of a piece on the board will be */
  static final int SQUARE_SIZE = 40;

  public interface SquareClickListener {
    public void squareClicked(int row, int col);
  }

  public interface SquareDragListener {
    public void squareDragged(int row, int col);
  }

  public interface SquareDropListener {
    public void squareDropped(int row, int col);
  }

  SquareView[][] grid = new SquareView[Board.SIZE][Board.SIZE];
  Board board;
  private int dropRow = 0, dropCol = 0;
  private SquareClickListener clickListener;
  private SquareDragListener dragListener;
  private SquareDropListener dropListener;

  /**
   * Initialized the board with grey squares
   *
   * @param board
   *          the board model object. Eventually this will model object will
   *          describe which squares are active
   */
  public BoardView(Board board) {
    clickListener = null;
    this.board = board;
    this.board.addPiece(new PlacedPiece(new Piece(new Square[] { new Square(0, 0) }), 0, 0));
    refresh();

    // This handle the drop of a piece on the board
    this.setOnDragDropped((DragEvent event) -> {
      Dragboard db = event.getDragboard();

      // use this to draw the piece on the board
      Piece piece = (Piece) db.getContent(Piece.dataFormat);

      PlacedPiece placedPiece = new PlacedPiece(piece, dropRow, dropCol);
      boolean added = this.board.addPiece(placedPiece);
      refresh();

      System.out.println("dropped " + added + " " + dropRow + " " + dropCol);

      // this might change we we actually implement it,
      // such as if they drop it on a square that doesn't exist
      event.setDropCompleted(true);
      event.consume();

    });

    // this is absolutely nessecary
    this.setOnDragOver((DragEvent event) -> {
      event.acceptTransferModes(TransferMode.MOVE);
      event.consume();
    });
  }

  public void setSquareClickListener(SquareClickListener listener) {
    this.clickListener = listener;
  }

  public void setSquareDraggedListener(SquareDragListener listener) {
    this.dragListener = listener;
  }

  public void setSquareDroppedListener(SquareDropListener listener) {
    this.dropListener = listener;
  }

  /**
   * Refreshes the view to match the current state of the board
   */
  public void refresh() {
    Square[][] squares = board.assembleSquares();
    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        grid[i][j] = new SquareView(SQUARE_SIZE, squares[i][j]);
        final int row = j;
        final int col = i;

        grid[i][j].setOnMouseClicked((e) -> {
          if (clickListener != null) {
            clickListener.squareClicked(row, col);
          }
        });

        grid[i][j].setOnDragDetected((e) -> {
          if (dropListener != null) {
            dragListener.squareDragged(row, col);
          }
        });

        grid[i][j].setOnDragOver((e) -> {
          e.acceptTransferModes(TransferMode.MOVE);
          e.consume();
        });

        grid[i][j].setOnDragDropped((e) -> {
          this.dropCol = col;
          this.dropRow = row;
          if (dropListener != null) {
            dropListener.squareDropped(row, col);
          }
        });
        this.add(grid[i][j], i, j);
      }
    }
  }
}
