package se.itu.tig015.main;

import se.itu.tig015.domain.Product;
import se.itu.tig015.storage.ProductLine;
import se.itu.tig015.storage.ProductLineFactory;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class TestProductLine {
  public static void main(String[] args) {

    ProductLine productLine = ProductLineFactory.getProductLine();
    List<Product> products = productLine.getAllProducts();
    int count = 0;
    int limit = 10;
    System.out.println("The first " + limit + " products;");
    for (Product product : products) {
      if (count < limit) {
        System.out.println(product);
      } else {
        break;
      }
      count++;
    }
    System.out.println("\n====================\nProducts with > 70% alcohol:");
    List<Product> strongStuff = productLine.getProductsFilteredBy(p -> p.alcohol() > 70.0);
    Collections.sort(strongStuff, Product.ALCOHOL_ORDER.reversed());
    for (Product product : strongStuff) {
      System.out.println(product);
    }
  }
}
