package se.itu.tig015.domain;

import java.util.Comparator;

/**
 * Represents a Product in a ProductLine.
 */
public class Product {
  
  private String name;
  private double price;
  private double alcohol;
  private int volume;

  /**
   * A Comparator that orders Products based on their name.
   */
  public static final Comparator<Product> NAME_ORDER = Comparator.comparing(Product::name);
  /**
   * A Comparator that orders Products based on their name, ignoring case.
   */
  public static final Comparator<Product> NAME_CASE_INSENSITIVE_ORDER =
    (p1, p2) -> p1.name().toLowerCase().compareTo(p2.name().toLowerCase());
  /**
   * A Comparator that orders Products based on their price.
   */
  public static final Comparator<Product> PRICE_ORDER = Comparator.comparing(Product::price);
  /**
   * A Comparator that orders Products based on their alcohol level.
   */
  public static final Comparator<Product> ALCOHOL_ORDER = Comparator.comparing(Product::alcohol);
  /**
   * A Comparator that orders Products based on their volume.
   */
  public static final Comparator<Product> VOLUME_ORDER = Comparator.comparing(Product::volume);
  
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

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (! (other instanceof Product)) {
      return false;
    }
    Product that = (Product)other;
    return this.name.equals(that.name) &&
      this.alcohol == that.alcohol &&
      this.volume == that.volume &&
      this.price == that.price;
  }
  
  @Override
  public int hashCode() {
    // Using hash algorithm from
    // Joshua Bloch - Effective Java - on hashcodes
    int code = 17;
    code = 31 * code + name.hashCode();
    long alc = Double.doubleToLongBits(alcohol);
    code = 31 * code + (int) (alc ^ (alc >>> 32));
    code = 31 * code + volume;
    long pri = Double.doubleToLongBits(price);
    code = 31 * code + (int) (pri ^ (pri >>> 32));
    return code;
  }
}
