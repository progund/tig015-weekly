import se.itu.systemet.storage.ProductLineFactory;
import se.itu.systemet.storage.ProductLine;
import se.itu.systemet.domain.Product;

import java.util.List;

public class AndroidSyntaxExample {
  public static void main(String[] args) {
    // No way to set system properties externally,
    // so we'll do it programmatically here:
    System.setProperty("sortiment-xml-file", "resources/sortiment.xml");
    ProductLine pl = ProductLineFactory.getProductLine();
    System.out.println(pl.getAllProducts().size());
  }
}
