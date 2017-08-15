import se.itu.systemet.storage.ProductLine;
import se.itu.systemet.storage.ProductLineFactory;
import se.itu.systemet.domain.Product;

public class TestWithJar {
  public static void main(String[] args) {
    for (Product product : ProductLineFactory.getProductLine().getAllProducts()) {
      System.out.println(product);
    }
  }
}
