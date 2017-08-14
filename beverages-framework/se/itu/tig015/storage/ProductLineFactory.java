package se.itu.tig015.storage;

import java.util.function.Predicate;
import java.util.List;

import se.itu.tig015.domain.Product;
  
public interface ProductLineFactory {

  public static ProductLine getProductLine() {
    return new XMLBasedProductLine();
  }
}
