import se.itu.systemet.storage.ProductLine;
import se.itu.systemet.storage.ProductLineFactory;
import se.itu.systemet.domain.Product;

import java.util.List;
import java.util.Iterator; // If you want to try looping with an Iterator


public class TestingObjects {
  public static void main(String[] args) {    
    // Your code here...

    // Task 4. Declare and initialize aProduct

    // Task 4. Declare and initialize anotherProduct

    // Task 4. Print aProduct
    // Task 4. Print anotherProduct
    
    // Task 4. Declare and initialize aSimilarProduct

    // Task 4. Test if aProduct thinks that it is equal to aSimilarProduct

    // Task 4. Test if anotherProduct is equal to aProduct

    // Task 5. Use the factory to get a ProductLine

    // Task 5. Use the ProductLine to get all products as a List<Product>

    // Task 5. Loop through all products and if alcohol is greater than 40.0%, print!

    // Task 5. Loop through all products again and if alcohol is 0.0%, print!

    // Voluntary challenge for those who want more:
    // If args.length is greater than 1 (there is at least one argument),
    // then convert args[0] to a double variable previously declared.
    // Use this variable in the first loop to compare against the loop product's
    // alcohol value. This allows the user to decide what the minimum alcohol
    // level for printing should be.
    // Hints:
    // Start by declaring a double called e.g. minimumAlcohol and initialize
    // it to 40.0 (which is the default value to check against).
    // Check if there are arguments to the program (e.g. args.length is not 0)
    // and if there are arguments, convert args[0] to a double value which you
    // assign to minimumAlcohol.
    // See the Java online API for java.lang.Double and the static method called
    // parseDouble(String) which you call like this:
    // Double.parseDouble(...) where the argument is args[0].
    // Change the first loop to use miminumAlcohol in the if-statement which
    // checks whether to print the product or not.
    // The argument checking etc must be written before the loop!
  }
}
