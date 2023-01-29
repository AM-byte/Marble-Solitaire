package cs3500.marblesolitaire.abstractFactory;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 *
 */
public class EuropeanSolitaireFactory implements MarbleSolitaireAbstractFactory {
  private int b; // board dimensions
  private int sRow; // row of the empty slot
  private int sCol; // column of the empty slot

  /**
   *
   * @param b
   * @param sRow
   * @param sCol
   */
  public EuropeanSolitaireFactory(int b, int sRow, int sCol) {
    this.b = b;
    this.sRow = sRow;
    this.sCol = sCol;
  }

  /**
   * Creates the appropriate model.
   *
   * @return the model
   */
  @Override
  public MarbleSolitaireModel createModel() {
    return new EuropeanSolitaireModel(this.b, this.sRow, this.sCol);
  }

  /**
   * Creates the appropriate view.
   *
   * @return the view
   */
  @Override
  public MarbleSolitaireView createView() {
    return new MarbleSolitaireTextView(this.createModel());
  }

  /**
   * Creates the appropriate view with an appendable.
   *
   * @param ap output of the view
   * @return the view with a given appendable
   */
  @Override
  public MarbleSolitaireView createView(Appendable ap) {
    return new MarbleSolitaireTextView(this.createModel(), ap);
  }

  /**
   * Creates the appropriate view with an appendable.
   *
   * @param model the model
   * @return the view with a given appendable
   */
  @Override
  public MarbleSolitaireView createView(MarbleSolitaireModel model) {
    return new MarbleSolitaireTextView(model);
  }

  /**
   * Creates the appropriate controller.
   *
   * @return the controller
   */
  @Override
  public MarbleSolitaireController
  createController(MarbleSolitaireModel m, MarbleSolitaireView v, Readable r) {
    return new MarbleSolitaireControllerImpl(m, v, r);
  }
}
