package se.itu.systemet.storage;

import java.util.function.Predicate;
import java.util.List;

import se.itu.systemet.domain.Product;

/**
 * Represents a ProductLine of beverages. This interface provides methods
 * for accessing the products in the product line.
 */
public interface ProductLine {

  /**
   * Returns a List&lt;Product&gt; with all products of the product line that satisfies the predicate.
   * @param predicate A Predicate with the criteria for the products to return
   * @return A List&lt;Product&gt; with all the Products that match the predicate
   */
  public List<Product> getProductsFilteredBy(Predicate<Product> predicate);

  /**
   * Returns a list of all the products in the product line.
   * @return A List&lt;Product&gt; with all the Products in the product line.
   */
  public List<Product> getAllProducts();

}
