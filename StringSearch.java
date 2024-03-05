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
  public static void main(String[] args){
//to get the contents
    String[] contents = Files.readString(Paths.get(args[0])).split("\n");

//to get the conditions
    String[] conditions = args[1].split("&");// 0 to 5 for the index
    int length, greater, less, first, last;
    String contains, starts, ends, replace;

    for(String s:conditions){
      if(s.contains("length")){
        length = Integer.parseInt(s.substring(7));
      }
      if(s.contains("greater")){
        greater = Integer.parseInt(s.substring(8));
      }
      if(s.contains("less")){
        less = Integer.parseInt(s.substring(6));
      }
      if(s.contains("contains")){
        for(String c:contents){
          if(c.contains(s.substring(10)){
            System.out.println(c);
          }
        }
      }
      if(s.contains("starts")){
        starts = s.substring(8);
      }
      if(s.contains("ends")){
        ends = s.substring(6);
      }
    }
//to get the operations  
    String[] transforms = args[2].split("&");
    for(String s:transforms){
      if(s.contains("upper")){
        
    }
      if(s.contains("lower")){
        
    }
      if(s.contains("first")){
        first = Integer.parseInt(s.substring(7));
    }
      if(s.contains("last")){
        last = Integer.parseInt(s.substring(6));
    }
      if(s.contains("replace")){
        String[] replaces = s.substring(9).split(";");
        
    }
  }
}
