package se.itu.systemet.main;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import java.util.List;

import se.itu.systemet.domain.Product;
import se.itu.systemet.storage.*;
/**
 * This class is a Java program which fires up a
 * Swing(tm) GUI (Graphical User Interface) which
 * displays all the products, read from the XML file
 * from Systembolaget, and lets the user filter the
 * products shown in various ways.
 */
public class TestSwing {

  /* A so called static initializer (as shown below)
   * is executed once (only one time) when the class
   * it belongs to if first loaded by the JVM.
   *
   * This particular one, fixes some UI problems
   * with e.g. Rikard's laptop which uses a really
   * high resolution and high dpi which otherwise
   * makes the window and components look really small.
   *
   * For other computers, which do not have the capabilities
   * which we try to use here, nothing happens.
   */
  static {
    try {
      // Ignore the lines below - it's a fix for Rikard's computer. Hell Dell!
      UIManager
        .setLookAndFeel((LookAndFeel)Class
                        .forName("com.sun.java.swing.plaf.gtk.GTKLookAndFeel")
                        .newInstance());
    } catch (Exception ignore) {}
  }

  /* This is the main method, i.e. the starting-point of this
   * Java program.
   */
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          GUI gui = new GUI(ProductLineFactory.getProductLine().getAllProducts());
        }
      });
  }
}

/**
 * This class (should really have been defined in its own
 * source code file - we apologize) represents a GUI with
 * a table and some text fields and buttons.
 */
class GUI {

  // Instance variables below - mostly Swing components for the UI  
  private JFrame frame; // this is the actual window
  private JPanel panel; // a panel is a surface to put other components on
  private JPanel form;  
  private JTable table; // A table which looks like a spread sheet, kind of
  private JTextField alcoField; // input fields
  private JTextField priceField;
  // An object for sorting a table will be used
  private TableRowSorter<ProductTableModel> sorter;

  // A list containing all the products from Systembolaget
  private List<Product> products;

  // Constructs a new GUI
  public GUI(List<Product> products) {
    this.products = products;
    init();
    show();
  }

  /* This sets up all the components.
   */
  private void init() {    
    frame = new JFrame("Testing swing table");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new JPanel(new GridLayout(1, 0));
    form = new JPanel(new GridLayout(2,2));
    table = new JTable(new ProductTableModel(products));
    sorter = new TableRowSorter<ProductTableModel>((ProductTableModel)table.getModel());
    table.setPreferredScrollableViewportSize(new Dimension(1600, 1600));
    table.setFillsViewportHeight(true);
    table.setRowHeight(30);
    table.setAutoCreateRowSorter(true);
    table.getColumnModel().getColumn(0).setPreferredWidth(400);
    table.setRowSorter(sorter);
    JScrollPane scrollPane = new JScrollPane(table);
    panel.add(scrollPane);
    panel.setOpaque(true);
    frame.add(panel, BorderLayout.CENTER);
    alcoField = new JTextField(20);
    priceField = new JTextField(20);
    form.add(new JLabel("Minimum alcolhol:"));
    form.add(alcoField);
    form.add(new JLabel("Maximum price:"));
    form.add(priceField);
    frame.add(form, BorderLayout.SOUTH);
    addListeners();
  }

  /* Here, we register objects which react to events,
   * to some components.
   */
  private void addListeners() {
    alcoField.getDocument()
      .addDocumentListener(new DocumentListener() {
          public void changedUpdate(DocumentEvent e) {
            newFilter();
          }
          public void insertUpdate(DocumentEvent e) {
            newFilter();
          }
          public void removeUpdate(DocumentEvent e) {
            newFilter();
          }
        });    
    priceField.getDocument()
      .addDocumentListener(new DocumentListener() {
          public void changedUpdate(DocumentEvent e) {
            newFilter();
          }
          public void insertUpdate(DocumentEvent e) {
            newFilter();
          }
          public void removeUpdate(DocumentEvent e) {
            newFilter();
          }
        });    
  }
  // Resets and updates the filter depending on what the
  // user writes in the text fields
  // See: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TableFilterDemoProject/src/components/TableFilterDemo.java
  // Yes, we (Rikard) were heavily influenced and inspired of that code ;-)
  private void newFilter() {
    List<RowFilter<ProductTableModel, Object>> rfs =
      new java.util.ArrayList<>();
    try {
      if(!alcoField.getText().equals("")) {
        rfs.add(RowFilter
                .numberFilter(RowFilter.ComparisonType.AFTER,
                              Double.parseDouble(alcoField.getText()),1));
      }
      if(!priceField.getText().equals("")) {
        rfs.add(RowFilter
                .numberFilter(RowFilter.ComparisonType.BEFORE,
                              Double.parseDouble(priceField.getText()),2));
      }
      
    } catch (Exception e) {
      return;
    }
    sorter.setRowFilter(RowFilter.andFilter(rfs));
  }

  // This method makes the window visible
  private void show() {
    frame.pack();
    frame.setVisible(true);
  }
}

/**
 * A class representing the contents of a table with products.
 * See: https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */
class ProductTableModel extends AbstractTableModel {
  private String[] columnNames = { "Name", "Alcohol", "Price", "Volume", "cl alc per SEK"};
  private Object[][] data;
  
  public ProductTableModel(List<Product> products) {
    data = new Object[products.size()][5];
    for (int i=0; i<products.size(); i++) {
      Product product = products.get(i);
      data[i][0] = product.name();
      data[i][1] = product.alcohol();
      data[i][2] = product.price();
      data[i][3] = product.volume();
      data[i][4] = product.alcohol()/100.0 * product.volume()/10 / product.price();
    }
  }

  public int getColumnCount() {
    return columnNames.length;
  }

  public int getRowCount() {
      return data.length;
    }

  public String getColumnName(int col) {
    return columnNames[col];
  }

  public Object getValueAt(int row, int col) {
    return data[row][col];
  }

  public Class getColumnClass(int c) {
    return getValueAt(0, c).getClass();
  }

  /*
  public void setValueAt(Object value, int row, int col) {
    data[row][col] = value;
    fireTableCellUpdated(row, col);
  }
  */
}
