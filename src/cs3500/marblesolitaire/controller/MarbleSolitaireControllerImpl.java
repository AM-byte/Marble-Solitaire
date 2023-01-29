package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements the operations offered by the marble solitaire controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable input;

  /**
   * Constructor for the marble solitaire controller.
   *
   * @param model the model
   * @param view the view
   * @param input to read input from
   * @throws NullPointerException if the model, view, or readable is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable input) throws IllegalArgumentException {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("Model, view or readable cannot be null.");
    }

    this.model = model;
    this.view = view;
    this.input = input;
  }

  /**
   * Plays a new game of marble solitaire.
   *
   * @throws IllegalStateException if the controller is unable to successfully
   *                               read input or transmit output
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner in = new Scanner(this.input);
    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol = 0;
    String[] positions = new String[] {"from row", "from column", "to row", "to col"};
    String userInput = "";
    boolean userDidQuit = false;

    while (!this.model.isGameOver() && !userDidQuit) {
      this.displayBoard();
      this.displayMessage("Score: " + this.model.getScore());

      boolean moveInvalid = true;

      while (moveInvalid) {
        for (int i = 0; i < positions.length; i++) {
          this.displayMessage("Enter the " + positions[i] + " starting at 1 or q to quit:");
          try {
            userInput = in.next();
          } catch (Exception e) {
            throw new IllegalStateException("Unable to read inputs from scanner!");
          }

          while (!isValidInput(userInput) ) {
            this.displayMessage("Invalid input. Play again:");
            try {
              userInput = in.next();
            } catch (Exception e) {
              throw new IllegalStateException("Unable to read inputs from scanner!");
            }
          }

          if (userInput.equalsIgnoreCase("q")) {
            userDidQuit = true;
            moveInvalid = false;
            break;
          }

          if (i == 0) {
            fromRow = Integer.parseInt(userInput) - 1;
          } else if (i == 1) {
            fromCol = Integer.parseInt(userInput) - 1;
          } else if (i == 2) {
            toRow = Integer.parseInt(userInput) - 1;
          } else if (i == 3) {
            toCol = Integer.parseInt(userInput) - 1;
          }
        }

        if (!moveInvalid) {
          break;
        }

        try {
          this.model.move(fromRow, fromCol, toRow, toCol);
          moveInvalid = false;
        } catch (IllegalArgumentException e) {
          this.displayMessage("Invalid move. Play again. " + e.getMessage());
        }
      }

    }

    if (userDidQuit) {
      this.displayMessage("Game quit!");
      this.displayMessage("State of game when quit:");
    } else {
      this.displayMessage("Game over!");
    }
    this.displayBoard();
    this.displayMessage("Score: " + this.model.getScore());
  }

  // displays the board
  private void displayBoard() throws IllegalStateException {
    try {
      this.view.renderMessage(this.view.toString() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  // displays the given message
  private void displayMessage(String message) throws IllegalStateException {
    try {
      this.view.renderMessage(message + "\n");
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * Checks if the given user input is one of: "q", "Q", integer.
   *
   * @param userInput user entered string
   * @return true if the input is valid
   * @throws NumberFormatException if the input is not a number
   */
  private boolean isValidInput(String userInput) throws NumberFormatException {
    int n;
    if (userInput.equalsIgnoreCase("q")) {
      return true;
    }
    try {
      n = Integer.parseInt(userInput);
      return n > 0;
    } catch (Exception e) {
      return false;
    }
  }
}
