/* In Java, the starting point of a program is the so called
 * "main method". Every method in Java exists in a so called
 * "class". This program's main exists in the Weekly02 class.
 *
 * A "public" class has to be saved in a text file with the
 * same name as the class followed by ".java".
 *
 * In this case, the Weekly02 class is saved in this file
 * with the name Weekly02.java .
 */
import se.itu.systemet.storage.ProductLineFactory;
import se.itu.systemet.storage.ProductLine;
import se.itu.systemet.domain.Product;
import java.util.List;

public class Weekly02 {
  /* Staring point of this small program */
  public static void main(String[] args) {
    // Make sure we have the XML file with the products!
    checkFile();
    // Get the ProductLine (Systembolage's all products)
    ProductLine catalog = ProductLineFactory.getProductLine();
    // Get a list of Product objects from the catalog
    List<Product> products = catalog.getAllProducts();
    System.out.println("We have a list with " + products.size() + " products");
  }
  /* Checks that the XML file is really in resources/sortiment.xml */
  static void checkFile() {
    if (! new java.io.File("resources/sortiment.xml").exists()) {
      System.err.println("I can't find the resources/sortiment.xml file.");
      System.err.println("You need to make sure you have it!");
      System.err.println("You can run ./get_latest_file.sh in order to get the latest version of this file, which will end up in the resources/ directory.");
      System.exit(1);
    } else {
      System.setProperty("sortiment-xml-file", "resources/sortiment.xml");
    }
  }
}
