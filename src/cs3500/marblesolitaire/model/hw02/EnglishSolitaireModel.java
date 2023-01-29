package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.ARectangleSolitaireModel;

/**
 * This class extends the operations offered by the marble solitaire model.
 * One object of the model represents one game of english solitaire.
 */
public class EnglishSolitaireModel extends ARectangleSolitaireModel {

  /**
   * Standard game board with no parameters, arm thickness of 3 and empty cell in the center
   * of the board.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Game board with the empty cell in user's desired position, arm thickness of 3.
   *
   * @param sRow row index of the empty cell
   * @param sCol column index of the empty cell
   * @throws IllegalArgumentException if the row or column index of the empty
   *                                  cell are out of bounds
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Game board given the arm thickness by the user and the empty cell in the center.
   *
   * @param a arm thickness of the board
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number
   */
  public EnglishSolitaireModel(int a) throws IllegalArgumentException {
    this(a, ((3 * a) - 2) / 2, ((3 * a) - 2) / 2);
  }

  /**
   * Game board with arm thickness and empty cell position given by the user.
   *
   * @param a    arm thickness of the board
   * @param sRow row index of the empty cell
   * @param sCol column index of the empty cell
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number or if the
   *                                  row or column index of the empty cell are out of bounds
   */
  public EnglishSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
    super(a, sRow, sCol);
  }

  /**
   * Checks if the given arguments are invalid.
   *
   * @param a    arm thickness
   * @param sRow row of the invalid slot
   * @param sCol column of the invalid slot
   * @return true if the given arguments are valid
   */
  @Override
  protected boolean isValidArguments(int a, int sRow, int sCol) {
    return (!(((a < 3) || (a % 2 == 0))
            || ((sRow < a - 1) && (sCol < a - 1))
            || ((sRow > ((2 * a) - 2) && (sCol < (a - 1))))
            || ((sRow < (a - 1)) && (sCol > (2 * a) - 2))
            || ((sRow > ((2 * a) - 2)) && (sCol > ((2 * a) - 2)))));
  }
}
