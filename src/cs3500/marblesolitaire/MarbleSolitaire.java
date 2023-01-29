package cs3500.marblesolitaire;

import java.io.InputStreamReader;
import java.util.Scanner;

import cs3500.marblesolitaire.abstractFactory.FactoryProducer;
import cs3500.marblesolitaire.abstractFactory.MarbleSolitaireAbstractFactory;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Class for the main method.
 */
public class MarbleSolitaire {
  /**
   * The main method.
   *
   * @param args string input
   */
  public static void main(String[] args) {
    Readable input = new InputStreamReader(System.in);
    Scanner in = new Scanner(System.in);
    MarbleSolitaireAbstractFactory marbleSolitaireFactory;
    MarbleSolitaireModel model;
    MarbleSolitaireView view;
    MarbleSolitaireController controller;
    String gameMode;
    int dimensions;
    int sRow;
    int sCol;

    System.out.println("Please decide game mode:\n" +
            "- english\n" +
            "- european\n" +
            "- triangle");
    gameMode = in.next();

    marbleSolitaireFactory = FactoryProducer.getFactory(gameMode);

    while (marbleSolitaireFactory == null) {
      System.out.println("Game mode not valid, please enter again. Valid options are:\n" +
              "- english\n" +
              "- european\n" +
              "- triangle");
      gameMode = in.next();
      marbleSolitaireFactory = FactoryProducer.getFactory(gameMode);
    }

//    System.out.println("Please set the board size:");
//    dimensions = in.nextInt();
//
//    System.out.println("Please set the empty slot (first row then column):");
//    sRow = in.nextInt();
//    sCol = in.nextInt();

//    marbleSolitaireFactory = FactoryProducer.setEmptySlot(sRow, sCol).getFactory(gameMode);

    model = marbleSolitaireFactory.createModel();
    view = marbleSolitaireFactory.createView(model);
    controller = marbleSolitaireFactory.createController(model, view, input);
    controller.playGame();
  }
}
