package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This abstract class implements the operations offered by the marble solitaire interface.
 */
public abstract class AMarbleSolitaireModel implements MarbleSolitaireModel {
  protected int a; // arm thickness
  protected SlotState[][] board; // game board
  protected int sRow; // empty slot row
  protected int sCol; // empty slot column

  /**
   * Constructor for every class that implements Marble Solitaire.
   *
   * @param a arm thickness
   * @param sRow row of the empty slot
   * @param sCol column of the empty slot
   * @throws IllegalArgumentException if the given arguments are invalid
   */
  public AMarbleSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
    if (!isValidArguments(a, sRow, sCol)) {
      throw new IllegalArgumentException("Invalid arguments");
    }

    this.a = a;
    this.sRow = sRow;
    this.sCol = sCol;
    this.populateBoard();
  }

  /**
   * Checks if the given arguments are invalid.
   *
   * @param a arm thickness
   * @param sRow row of the invalid slot
   * @param sCol column of the invalid slot
   * @return true if the given arguments are valid
   */
  protected abstract boolean isValidArguments(int a, int sRow, int sCol);

  /**
   * Populates the board with cells.
   */
  private void populateBoard() {
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (!isValidArguments(this.a, row, col)) {
          this.board[row][col] = SlotState.Invalid;
        } else if ((row == this.sRow) && (col == this.sCol)) { // empty cell
          this.board[row][col] = SlotState.Empty;
        } else { // any other position on the board
          this.board[row][col] = SlotState.Marble;
        }
      }
    }
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public abstract void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException;

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public abstract boolean isGameOver();

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */
  @Override
  public abstract int getBoardSize();

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if ((row < 0) || (col < 0) || (row >= this.getBoardSize()) || (col >= this.getBoardSize())) {
      throw new IllegalArgumentException("The row or the column are beyond the dimensions "
              + "of the board");
    } else {
      return this.board[row][col];
    }
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int marbles = 0;
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (this.board[row][col] == SlotState.Marble) {
          marbles++;
        }
      }
    }
    return marbles;
  }
}
