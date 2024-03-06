
import java.nio.file.*;
import java.io.IOException;
class FileHelper {
    static String[] getLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).toArray(String[]::new);
        }
        catch(IOException e) {
            System.err.println("Error reading file " + path + ": " + e);
            return new String[]{"Error reading file " + path + ": " + e};
        }
    }
}
class StringSearch{
    public static void main(String[] args) throws IOException{
  //to get the contents
      String[] contents = Files.readString(Paths.get(args[0])).split("\n");
      for (String line : contents) {
        System.out.println(line);
      }
    }
}