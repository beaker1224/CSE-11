import java.nio.file.*;
import java.io.IOException;
import java.util.*;
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
  boolean matches(String s);
}

class StringSearch{
  public static void main(String[] args) throws IOException{
    //to get the contents
          String[] contents = Files.readString(Paths.get(args[0])).split("\n");
          ArrayList<String> output = new ArrayList<>();

    //to check if there the number of commands in the command line
        if(args.length == 1){
            for (String line : contents) {
                System.out.println(line);
              }
        }else if(args.length == 2){
            String[] queryLine = args[1].split("&");
            Query[] queries = new Query[queryLine.length];
            
            for(int i = 0; i < queryLine.length; i++){
                queries[i] = readQuery(queryLine[i]);
            }

            for(int i = 0; i < contents.length; i ++){
                boolean Allpassed = true;
                for(int j = 0; j < queries.length; j++){
                    Allpassed = Allpassed && queries[j].matches(contents[i]);
                    }
                if(Allpassed){
                    output.add(contents[i]);
                    System.out.println(contents[i]);
                }
            }

          /*  for(String s:output){
            System.out.println(output);
            } */


        }//2 conditions if statement
      }// main method


      static Query readQuery(String q){
        if(q.startsWith("length=")){
            return new LengthQuery(Integer.parseInt(q.substring(7)));
        }
        if(q.startsWith("greater=")){
            return new GreaterQuery(Integer.parseInt(q.substring(8)));
        } 
        if(q.startsWith("less=")){
            return new LessQuery(Integer.parseInt(q.substring(5)));
        }
        if(q.startsWith("contains=")){
            return new ContainsQuery(q.substring(10, q.length() - 1));
        }
        if(q.startsWith("starts=")){
            return new StartsQuery(q.substring(8, q.length() - 1));
        }
        if(q.startsWith("ends=")){
            return new EndsQuery(q.substring(6, q.length() - 1));
        }
        if(q.startsWith("not")){
            return new NotQuery(q.substring(4, q.length() - 1));
        }
        return null;//then it fails
      }
}// class

class LengthQuery implements Query{
    int n;
    LengthQuery(int n){
        this.n = n;
    }

    public boolean matches(String s){
        return n == s.length();
    }
}
class GreaterQuery implements Query{
    int n;
    GreaterQuery(int n){
        this.n = n;
    }

    public boolean matches(String s){
        return s.length() > n;
    }
}
class LessQuery implements Query{
    int n;
    LessQuery(int n){
        this.n = n;
    }

    public boolean matches(String s){
        return s.length() < n;
    }
}
class ContainsQuery implements Query {
    String query;
    ContainsQuery(String query) {
      this.query = query;
    }
  
    public boolean matches(String s) {
      return s.contains(this.query);
  }
}
class StartsQuery implements Query{
    String query;
    StartsQuery(String query) {
      this.query = query;
    }
  
    public boolean matches(String s) {
      return s.startsWith(this.query);
  }
}
class EndsQuery implements Query{
    String query;
    EndsQuery(String query) {
      this.query = query;
    }
  
    public boolean matches(String s) {
      return s.endsWith(this.query);
  }
}
class NotQuery implements Query{
    String query;
    NotQuery(String query) {
      this.query = query;
    }
  
    public boolean matches(String s) {
      return !(StringSearch.readQuery(query).matches(s));
  }
}