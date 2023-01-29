package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This abstract class implements the operations offered by the view of the marble solitaire.
 */
public abstract class AMarbleSolitaireTextView implements MarbleSolitaireView {
  protected MarbleSolitaireModelState model;
  protected Appendable output;

  /**
   * Provides the view with all the methods it needs to query and print the board.
   *
   * @param model object of the marble solitaire model.
   * @param output the output that the view can use to display the baord.
   * @throws IllegalArgumentException if the model is null.
   */
  public AMarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable output) throws
          IllegalArgumentException {
    if (model == null || output == null) {
      throw new IllegalArgumentException("Provided model or output is null");
    }
    this.model = model;
    this.output = output;
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
  public abstract String toString();

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above.
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    try {
      this.output.append(this.toString());
    } catch (IOException e) {
      throw new IOException(e.getMessage());
    }
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.output.append(message);
    } catch (IOException e) {
      throw new IOException(e.getMessage());
    }

  }
}
