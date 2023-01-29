package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class implements MarbleSolitaireView that represents operations
 * that should be offered by a view for the Triangle solitaire game.
 */
public class TriangleSolitaireTextView extends AMarbleSolitaireTextView {

  /**
   * Provides the view with all the methods it needs to query and print the board.
   *
   * @param model object of the marble solitaire model.
   * @throws IllegalArgumentException if the model is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) throws
          IllegalArgumentException {
    this(model, System.out);
  }

  /**
   * Provides the view with all the methods it needs to query and print the board.
   *
   * @param model object of the marble solitaire model.
   * @param output the output that the view can use to display the baord.
   * @throws IllegalArgumentException if the model is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable output) throws
          IllegalArgumentException {
    super(model, output);
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  public String toString() {
    StringBuilder boardDrawing = new StringBuilder("");
    for (int row = 0; row < model.getBoardSize(); row++) {
      for (int col = 0; col < model.getBoardSize(); col++) {
        String boardSoFar = "";
        for (int spaces = 0; spaces < model.getBoardSize() - row - 1; spaces++) {
          if (col == 0) {
            boardSoFar = boardSoFar + " ";
          }
        }
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
          boardSoFar = boardSoFar + "O";
        }
        if (model.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
          boardSoFar = boardSoFar + "_";
        }

        if (!(boardSoFar.equals(""))) {
          if (col != 0) {
            boardDrawing.append(" ");
          }
          boardDrawing.append(boardSoFar);
        }

      }
      if (row != model.getBoardSize() - 1) {
        boardDrawing.append("\n");
      }
    }
    return boardDrawing.toString();
  }
}
