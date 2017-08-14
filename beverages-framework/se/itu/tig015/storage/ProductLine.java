package se.itu.tig015.storage;

import java.util.function.Predicate;
import java.util.List;

import se.itu.tig015.domain.Product;
  
public interface ProductLine {

  public List<Product> getProductsFilteredBy(Predicate<Product> predicate);
  
  public List<Product> getAllProducts();

}
