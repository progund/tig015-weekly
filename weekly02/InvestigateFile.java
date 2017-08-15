import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.charset.StandardCharsets.UTF_8;

public class InvestigateFile {
  public static void main(String[] args) {
    File sortiment = new File("sortiment.xml");
    String fileName = sortiment.getName();
    long bytes = sortiment.length();
    System.out.printf("%s contains %d bytes of text\n",
                      fileName,
                      bytes);
    try {
      BufferedReader reader = Files.newBufferedReader(sortiment.toPath(),
                                                      UTF_8);
      int c = 1;
      String line = null;
      while (c < 12) {
        line = reader.readLine();
        c++;
      }
      System.out.println("The 11th line of " + fileName + " is " + line);
    } catch (IOException ioe) {
      System.err.println("Error reading file: " + ioe.getMessage());
    }
  }
}
