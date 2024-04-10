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

interface Transform{
    String transform(String s);
}

class StringSearch{
  public static void main(String[] args) throws IOException{
    //to get the contents
          String[] contents = Files.readString(Paths.get(args[0])).split("\n");
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
                    System.out.println(contents[i]);
                }
            }
        }//2 conditions if statement
        else if(args.length == 3){
            String[] queryLine = args[1].split("&");
            Query[] queries = new Query[queryLine.length];
            String output = "";
            
            for(int i = 0; i < queryLine.length; i++){
                queries[i] = readQuery(queryLine[i]);
            }

            for(int i = 0; i < contents.length; i ++){
                boolean Allpassed = true;
                for(int j = 0; j < queries.length; j++){
                    Allpassed = Allpassed && queries[j].matches(contents[i]);
                    }
                if(Allpassed){
                    output += (contents[i]) + "\n";
                }
                //System.out.println(output);
            }// for checking Query

            String[] in = output.split("\n");
            String[] transformLine = args[2].split("&");
            Transform[] transforms = new Transform[transformLine.length];
            
            for(int i = 0; i < transformLine.length; i++){
                transforms[i] = readTransform(transformLine[i]);
            }

            String after = "";
            for(int i = 0; i < in.length; i++){
                for(int j = 0; j < transformLine.length; j++){
                    in[i] = transforms[j].transform(in[i]);
                }
                after += in[i] + "&";
            }//for checking Transforms
            String[] afterTotal = after.split("&");
            for(String a:afterTotal){
                System.out.println(a);
            }

        }//3 conditions
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
      }//Query readQuery static class

      static Transform readTransform(String t){
        if(t.startsWith("upper")){
            return new UpperTransform();
        }
        if(t.startsWith("lower")){
            return new LowerTransform();
        }
        if(t.startsWith("first=")){
            return new FirstTransform(Integer.parseInt(t.substring(6)));
        }
        if(t.startsWith("last=")){
            return new LastTransform(Integer.parseInt(t.substring(5)));
        }
        if(t.startsWith("replace=")){
            String[] w = t.substring(9).split("';'");
            String w1 = w[0];
            String w2 = w[1].substring(0, w[1].length() - 1);
            return new ReplaceTransform(w1, w2);
        }
        return null;
      }
}// class

//Query class sets implements Query
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

//Transform class sets implements Transform
class UpperTransform implements Transform{
    public String transform(String s){
        return s.toUpperCase();
    }
}
class LowerTransform implements Transform{
    public String transform(String s){
        return s.toLowerCase();
    }
}
class FirstTransform implements Transform{
    int n;
    FirstTransform(int n){
        this.n = n;
    }

    public String transform(String s){
        if(s.length() < n){
            return s;
        }
        String out = s.substring(0, n);
        return out;
    }
}
class LastTransform implements Transform{
    int n;
    LastTransform(int n){
        this.n = n;
    }

    public String transform(String s){
        String out = s.substring(s.length() - n, s.length());
        return out;
    }
}
class ReplaceTransform implements Transform{
    String str1, str2;
    ReplaceTransform(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    public String transform(String s){
        return s.replace(str1, str2);
    }
}