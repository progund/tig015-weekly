/* Build and run:
 * Windows:
 * Build: 
 * javac -Dsortiment-xml-file=resources/sortiment.xml -cp "systemet.jar;. ExampleWeekly.java
 * Run:
 * java -cp "systemet.jar;." ExampleWeekly"
 *
 * Unix/GNU/Linux:
 * Build:
 * javac -Dsortiment-xml-file=resources/sortiment.xml -cp systemet.jar:. ExampleWeekly.java
 * Run:
 * java -Dsortiment-xml-file=resources/sortiment.xml -cp systemet.jar:. ExampleWeekly"
 * Or use build and run scripts...
 */
import se.itu.systemet.storage.ProductLineFactory;
import se.itu.systemet.storage.ProductLine;
import se.itu.systemet.domain.Product;

import java.util.List;
/* Task1: Count how many products are in the ProductLine.
 * Task2: Print all products whose name start with "Pilsner"
 */
public class ExampleWeekly {
  public static void main(String[] args) {
    // Get the ProductLine:
    ProductLine productLine = ProductLineFactory.getProductLine();
    // Get all Products:
    List<Product> products = productLine.getAllProducts();
    // Variable to count loop iterations
    int count = 0;
    // Loop through all products:
    for (Product product : products) {
      // Increment count
      count++;
    }
    // Print the result:
    System.out.println("Found " + count + " products");
    // or a bit simpler:
    System.out.println("There are " + products.size() + " products");

    // Print all products whose name starts with "Pilsner":
    for (Product product : products) {
      if (product.name().startsWith("Pilsner")) {
        System.out.println(product.name());
      }
    }
    /* Example output:
Found 18846 products
There are 18846 products
Pilsner Urquell
Pilsner 172
Pilsner Urquell
    */
  }
}
