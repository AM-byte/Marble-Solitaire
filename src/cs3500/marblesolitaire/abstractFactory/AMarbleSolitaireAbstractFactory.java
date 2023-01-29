package cs3500.marblesolitaire.abstractFactory;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

public class AMarbleSolitaireAbstractFactory implements MarbleSolitaireAbstractFactory {

  /**
   * Creates the appropriate model.
   *
   * @return the model
   */
  @Override
  public MarbleSolitaireModel createModel() {
    return null;
  }

  /**
   * Creates the appropriate view.
   *
   * @return the view
   */
  @Override
  public MarbleSolitaireView createView() {
    return null;
  }

  /**
   * Creates the appropriate view with an appendable.
   *
   * @param ap output of the view
   * @return the view with a given appendable
   */
  @Override
  public MarbleSolitaireView createView(Appendable ap) {
    return null;
  }

  @Override
  public MarbleSolitaireView createView(MarbleSolitaireModel model) {
    return null;
  }

  /**
   * Creates the appropriate controller.
   *
   * @param m
   * @param v
   * @param r
   * @return the controller
   */
  @Override
  public MarbleSolitaireController createController(MarbleSolitaireModel m, MarbleSolitaireView v, Readable r) {
    return null;
  }
}
