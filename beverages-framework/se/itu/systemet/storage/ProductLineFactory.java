package se.itu.systemet.storage;

import java.util.function.Predicate;
import java.util.List;

import se.itu.systemet.domain.Product;

/**
 * Factory class for creating ProductLine objects.
 */
public class ProductLineFactory {

  /**
   * Creates a ProductLine object.
   * @return A new ProductLine object
   */
  public static ProductLine getProductLine() {
    return new XMLBasedProductLine();
  }
}
