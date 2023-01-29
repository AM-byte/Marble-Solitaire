package cs3500.marblesolitaire.abstractFactory;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 *
 */
public interface MarbleSolitaireAbstractFactory {
  /**
   * Creates the appropriate model.
   *
   * @return the model
   */
  MarbleSolitaireModel createModel();

  /**
   * Creates the appropriate view.
   *
   * @return the view
   */
  MarbleSolitaireView createView();

  /**
   * Creates the appropriate view with an appendable.
   *
   * @param ap output of the view
   * @return the view with a given appendable
   */
  MarbleSolitaireView createView(Appendable ap);

  /**
   * Creates the appropriate view with an appendable.
   *
   * @param model the model
   * @return the view with a given appendable
   */
  MarbleSolitaireView createView(MarbleSolitaireModel model);

  /**
   * Creates the appropriate controller.
   *
   * @return the controller
   */
  MarbleSolitaireController
  createController(MarbleSolitaireModel m, MarbleSolitaireView v, Readable r);
}
