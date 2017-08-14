package se.itu.tig015.domain;

/**
 * Represents a Product in a ProductLine.
 */
public class Product {
  
  private String name;
  private double price;
  private double alcohol;
  private int volume;

  /**
   * Constructs a new Product.
   * @param name The name of this Product
   * @param alcohol The alcohol level (in percent alcohol by weight) of this Product
   * @param price The price of this Product (in SEK)
   * @param volume The volume (in millilitres) of this product
   */
  public Product(String name, double alcohol, double price, int volume) {
    this.name = name;                     
    this.alcohol = alcohol;
    this.price = price;
    this.volume = volume;
  }

  /**
   * Returns the name of this Product
   * @return The name of this Product
   */
  public String name() { return name; }

  /**
   * Returns the alcohol level of this Product
   * @return The alcohol level of this Product
   */
  public double alcohol() { return alcohol; }

  /**
   * Returns the price of this Product
   * @return The price of this Product
   */
  public double price() { return price; }

  /**
   * Returns the volume of this Product
   * @return The volume of this Product
   */
  public int volume() { return volume; }
  
  /**
   * Returns this Product as a String on the format:
   *<pre>
   *NAME, PERCENT_ALCOHOL%, VOLUME ml, PRICE SEK
   *</pre>
   * For instance:
   *<pre>
   *Renat, 37.50%, 700 ml, 209.00 SEK
   *</pre>
   * @return this Product as a String
   */
  @Override
  public String toString() {
    return name + ", " +
      String.format("%.2f", alcohol) + "%, " +
      volume + " ml" + ", " +
      String.format("%.2f", price) + " SEK";
  }
}
