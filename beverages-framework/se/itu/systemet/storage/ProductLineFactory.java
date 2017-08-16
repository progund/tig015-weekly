package se.itu.systemet.storage;

import java.util.function.Predicate;
import java.util.List;

import se.itu.systemet.domain.Product;

/**
 * <p>Factory class for creating ProductLine objects.</p>
 * <p>Typical usage:</p>
 * <pre>
 * ProductLine productLine = ProductLineFactory.getProductLine();
 * List<Product> products = productLine.getAllProducts();
 * </pre>
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
