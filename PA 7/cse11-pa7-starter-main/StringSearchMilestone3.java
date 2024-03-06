import java.nio.file.*;
import java.io.IOException;

class FileHelper {
  static String[] getLines(String path) {
    try {
      return Files.readAllLines(Paths.get(path)).toArray(String[]::new);
    } catch (IOException e) {
      System.err.println("Error reading file " + path + ": " + e);
      return new String[] { "Error reading file " + path + ": " + e };
    }
  }
}

interface Query {
  public boolean matches(String s);
}

class ContainsQuery implements Query {
  String query;

  ContainsQuery(String query) {
    this.query = query;
  }

  public boolean matches(String s) {
    if (s.contains(this.query)) {
      return true;
    }
    return false;
  }
}

class StringSearch implements Query {
  public static void main(String[] args) throws IOException{
    //to get the contents
          String[] contents = Files.readString(Paths.get(args[0])).split("\n");
          String[] output;

          
          public boolean matches(String s){
            return;
          }
          static Query readQuery(String q){
            
          }
    //Queries
        int length, greater, less;
        String contains, starts, ends, not;

    //to check if there the number of commands in the command line
        if(args.length == 1){
            for (String line : contents) {
                System.out.println(line);
              }
        }

        if(args.length == 2){
            String[] conditions = args[1].split("&");
    //print test
    /*for(String c:conditions){
        System.out.println(c);
    }*/
    //print test ends
            for(String s:conditions){
                if(s.contains("length")){
                  length = Integer.parseInt(s.substring(7));
                }
                if(s.contains("greater")){
                  greater = Integer.parseInt(s.substring(8));
                }
                if(s.contains("less")){
                  less = Integer.parseInt(s.substring(5));
                }
                if(s.contains("contains")){
    /*             ContainsQuery query = new ContainsQuery(s.substring(10, s.length() - 1));
                    for (String line : contents) {
                        if(query.matches(line)){
                            System.out.println(line);
                        }
                    }*/    
                }
                if(s.contains("starts")){
                  starts = s.substring(8);
                }
                if(s.contains("ends")){
                  ends = s.substring(6);
                }
                if(s.contains("not")){

                }
              }

        }//2 conditions if statement
      }// main method
}// class
