import se.itu.systemet.storage.ProductLine;
import se.itu.systemet.storage.ProductLineFactory;
import se.itu.systemet.domain.Product;

import java.util.List;
import java.util.Iterator; // If you want to try looping with an Iterator


public class TestingObjects {
  public static void main(String[] args) {    
    // Your code here...

    // Task 4. Create some custom project objects
    
    //  Declare and initialize aProduct

    //  Declare and initialize anotherProduct

    //  Next, add two println statements for printing the objects to standard out
    //   Print aProduct
    
    //   Print anotherProduct

    //  Now, compile and run (see instructions) before moving on with the below...

    // Next (after the println statements) create a third product
    //  Declare and initialize aSimilarProduct

    //  Test if aProduct thinks that it is equal to aSimilarProduct

    //  Test if anotherProduct is equal to aProduct

    // Task 6. Filter products on alcohol level
    //  Use the factory to get a ProductLine

    //  Use the ProductLine to get all products as a List<Product>

    //  Loop through all products and if alcohol is greater than 40.0%, print!

    //  Loop through all products again and if alcohol is 0.0%, print!

    // You are now finished with this weekly. Well done!
    
    // Voluntary extra challenge (for the keen student):
    // 
    // If args.length is greater than 0 (there is at least one argument),
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
    
    // NOTE: The argument checking etc must be written before the loop!
  }
}
