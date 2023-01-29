package cs3500.marblesolitaire.abstractFactory;

/**
 *
 */
public class FactoryProducer<T extends FactoryProducer<T>> {

  protected int d;
  protected int sRow;
  protected int sCol;

  public FactoryProducer(int d, int sRow, int sCol) {
    this.d = d;
    this.sRow = sRow;
    this.sCol = sCol;
  }

//  /**
//   *
//   * @param d
//   */
//  public static void setD(int d) {
//    d = d;
//  }
//
//  public static void setEmptySlot(int sRow, int sCol) {
//    FactoryProducer.sRow = sRow;
//    FactoryProducer.sCol = sCol;
//  }

  /**
   * Gets the factory.
   *
   * @param name name of the factory
   * @return the factory
   */
  public static MarbleSolitaireAbstractFactory getFactory(String name) {
    if (name.equalsIgnoreCase("english")) {
      return new EnglishSolitaireFactory(3, 3, 3);
    } else if (name.equalsIgnoreCase("european")) {
      return new EuropeanSolitaireFactory(3, 3, 3);
    } else if (name.equalsIgnoreCase("triangle")) {
      return new TriangleSolitaireFactory(5, 0, 0);
    }
    return null;
  }
}
