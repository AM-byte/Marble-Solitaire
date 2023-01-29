package cs3500.marblesolitaire.controller;

/**
 * This interface represents the operations offered by the marble solitaire
 * controller.
 */
public interface MarbleSolitaireController {
  /**
   * Plays a new game of marble solitaire.
   *
   * @throws IllegalStateException if the controller is unable to successfully
   *                               read input or transmit output
   */
  void playGame() throws IllegalStateException;
}
