package cs3500.marblesolitaire.model.hw04;

/**
 * This class extends the operations offered by the marble solitare model.
 * One object of the model represents one game of european solitare.
 */
public class EuropeanSolitaireModel extends ARectangleSolitaireModel {

  /**
   * Creates an octagonal board whose sides have length 3, with the empty slot
   * in the center of the board.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Creates a game with the specified side length, and the empty slot in
   * the center of the board.
   *
   * @param a arm thickness of the board
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number
   */
  public EuropeanSolitaireModel(int a) throws IllegalArgumentException {
    this(a, ((3 * a) - 2) / 2, ((3 * a) - 2) / 2);
  }

  /**
   * Creates a game with the specified initial position of the empty slot,
   * in a board of default size 3.
   *
   *
   * @param sRow row index of the empty cell
   * @param sCol column index of the empty cell
   * @throws IllegalArgumentException if the row or column index of the empty
   *                                  cell are out of bounds
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Creates a game with the specified side length, and the specified initial position
   * of the empty slot.
   *
   * @param a arm thickness of the board
   * @param sRow row index of the empty cell
   * @param sCol column index of the empty cell
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number or if the
   *                                  row or column index of the empty cell are out of bounds
   */
  public EuropeanSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
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
    return (!((a < 3) || (a % 2 == 0)
            || ((sRow + sCol) < a - 1)
            || (sCol <= (sRow - (a * 2) + 1))
            || (sRow <= (sCol - (a * 2) + 1))
            || ((sRow + sCol) >= ((5 * a) - 4))));
  }
}
