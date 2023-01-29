package cs3500.marblesolitaire.model.hw04;

/**
 * This abstract class extends the abstract marble solitaire
 * model and implements a few of its operations.
 */
public abstract class ARectangleSolitaireModel extends AMarbleSolitaireModel {

  /**
   * Constructor for every class that implements Marble Solitaire.
   *
   * @param a    arm thickness
   * @param sRow row of the empty slot
   * @param sCol column of the empty slot
   * @throws IllegalArgumentException if the given arguments are invalid
   */
  public ARectangleSolitaireModel(int a, int sRow, int sCol) throws IllegalArgumentException {
    super(a, sRow, sCol);
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
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int betweenRow;
    int betweenCol;
    if (fromRow < 0 || fromRow > this.getBoardSize() - 1
            || toRow < 0 || toRow > this.getBoardSize() - 1
            || fromCol < 0 || fromCol > this.getBoardSize() - 1
            || toCol < 0 || toCol > this.getBoardSize() - 1) {
      throw new IllegalArgumentException("The 'from' or 'to' positions are out of bounds"
              + "of the the board");
    }
    if (!(this.board[fromRow][fromCol].equals(SlotState.Marble))) {
      throw new IllegalArgumentException("The specified 'from' position doesn't have a marble");
    }
    if (!(this.board[toRow][toCol].equals(SlotState.Empty))) {
      throw new IllegalArgumentException("The specified 'to' position is not empty");
    }
    if (fromRow == toRow) {
      if (!(toCol == fromCol + 2 || toCol == fromCol - 2)) {
        throw new IllegalArgumentException("The 'to' and 'from' positions are not two slots away "
                + "from each other");
      }
    } else if (fromCol == toCol) {
      if (!(toRow == fromRow + 2 || toRow == fromRow - 2)) {
        throw new IllegalArgumentException("The 'to' and 'from' positions are not two slots away "
                + "from each other");
      }
    } else {
      throw new IllegalArgumentException("The 'to' and 'from' positions are not two"
              + " slots away from each other");
    }
    if (fromRow == toRow) {
      betweenRow = fromRow;
    } else {
      if (fromRow + 2 == toRow) {
        betweenRow = fromRow + 1;
      } else {
        betweenRow = fromRow - 1;
      }
    }
    if (fromCol == toCol) {
      betweenCol = fromCol;
    } else {
      if (fromCol + 2 == toCol) {
        betweenCol = fromCol + 1;
      } else {
        betweenCol = fromCol - 1;
      }
    }
    if (!(this.board[betweenRow][betweenCol].equals(SlotState.Marble))) {
      throw new IllegalArgumentException("The 'to' and 'from' positions don't "
              + "have a marble in the slot between them");
    }
    this.board[fromRow][fromCol] = SlotState.Empty;
    this.board[betweenRow][betweenCol] = SlotState.Empty;
    this.board[toRow][toCol] = SlotState.Marble;
  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    for (int row = 0; row < this.getBoardSize(); row++) {
      for (int col = 0; col < this.getBoardSize(); col++) {
        if (this.getSlotAt(row, col) == SlotState.Marble) {
          if (row > 1) {
            if (this.getSlotAt(row - 1, col) == SlotState.Marble
                    && this.getSlotAt(row - 2, col) == SlotState.Empty) {
              return false;
            }
          }
          if (row < this.getBoardSize() - 2) {
            if (this.getSlotAt(row + 1, col) == SlotState.Marble
                    && this.getSlotAt(row + 2, col) == SlotState.Empty) {
              return false;
            }
          }
          if (col > 1) {
            if (this.getSlotAt(row, col - 1) == SlotState.Marble
                    && this.getSlotAt(row, col - 2) == SlotState.Empty) {
              return false;
            }
          }
          if (col < this.getBoardSize() - 2) {
            if (this.getSlotAt(row, col + 1) == SlotState.Marble
                    && this.getSlotAt(row, col + 2) == SlotState.Empty) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return (3 * this.a) - 2;
  }
}
