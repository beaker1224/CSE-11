import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}
class PointCompare implements Comparator<Point>{
  public int compare(Point p1, Point p2){
    if(p1.x > p2.x){
      return 1;
    }else if(p1.x < p2.x){
      return -1;
    }else{
      if(p1.y > p2.y){
        return 1;
      }else if(p1.y < p2.y){
        return -1;
      }else{
        return 0;
      }
    }
  }//end of the compare method
}//end of the class PointCompare

class PointDistanceCompare implements Comparator<Point>{
  public int compare(Point p1, Point p2){
    if(p1.distance(new Point(0, 0)) < p2.distance(new Point(0, 0))){
      return -1;
    }else if(p1.distance(new Point(0, 0)) == p2.distance(new Point(0, 0))){
      return 0;
    }else{
      return 1;
    }
  }
}//end of the class PointDistanceCompare

class StringCompare implements Comparator<String>{
  public int compare(String str1, String str2){
    return str1.compareTo(str2);
  }
}

class StringLengthCompare implements Comparator<String>{
  public int compare(String str1, String str2){
    if(str1.length() > str2.length()){ return 1; }
    else if(str1.length() == str2.length()){ return 0; }
    else{ return -1; }
  }
}

class BooleanCompare implements Comparator<Boolean>{
  public int compare(Boolean b1, Boolean b2){
    if(b1 && b2 || (!b1 && !b2)){
      return 0;
    }else if(b1){
      return 1;
    }else{
      return -1;
    }
  }
}

class CompareLists{
  <E> E maximum(List<E> list, Comparator<E> c){
    if(list.isEmpty()){return null;}
    E max = list.get(0);
    for(int i = 0; i < list.size(); i++){
      if(c.compare(list.get(i), max) > 0){
        max = list.get(i);
      }
    }
    return max;
  }//end of function

  <E> E maximum(E[] E_array, Comparator<E> c){
    if(E_array.length == 0){return null;}
    E max = E_array[0];
    for(int i = 0; i < E_array.length; i++){
      if(c.compare(E_array[i], max) > 0){
        max = E_array[i];
      }
    }
    return max;
  }//end of the method

  <E> List<E> lesserThan(List<E> list, Comparator<E> c, E e){
    if(list.isEmpty()){return null;}
    List<E> out = new ArrayList<>();
    for(int i = 0; i < list.size(); i++){
      if(c.compare(list.get(i), e) < 0){
        out.add(list.get(i));
      }
    }
    return out;
  }//end of the method

  <E> boolean inOrder(List<E> list, Comparator<E> c){
    if(list.contains(null)){throw new IllegalArgumentException("null value in list");}
    for(int i = 0; i < list.size() - 1; i++){
      if(c.compare(list.get(i), list.get(i+1)) > 0){
        return false;
      }
    }
    return true;
  }//end of the method

  <E> boolean inOrder(E[] E_array, Comparator<E> c){
    for(int i = 0; i < E_array.length; i++){
      if(E_array[i] == null){throw new IllegalArgumentException("null value in array");}
    }
    for(int i = 0; i < E_array.length - 1; i++){
      if(c.compare(E_array[i], E_array[i+1]) > 0){
        return false;
      }
    }
    return true;
  }//end of the method

  <E> List<E> merge(Comparator<E> c, List<E> list1, List<E> list2){
    if(list1.contains(null)){throw new IllegalArgumentException("null value in first list");}
    if(list2.contains(null)){throw new IllegalArgumentException("null value in second list");}
    int a = 0;
    int b = 0;
    List<E> out = new ArrayList<>();
    while(a < list1.size() && b < list2.size()){
      if(c.compare(list1.get(a), list2.get(b)) < 0){
        out.add(list1.get(a));
        a ++;
      }
      else{
        out.add(list2.get(b));
        b ++;
      }
    }

    while(a < list1.size()){
      out.add(list1.get(a));
      a ++;
    }
    while(b < list2.size()){
      out.add(list2.get(b));
      b ++;
    }
    return out;
  }
}//end of the class


/*class Examples{
  void testExamples(Tester t){
    //class Points
    Point p1 = new Point(1, 0);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(-2, -5);
    Point p4 = new Point(2, 2);
    //class PointCompare
    PointCompare P = new PointCompare();
    t.checkExpect(P.compare(p1, p2), -1);
    t.checkExpect(P.compare(p2, p1), 1);
    t.checkExpect(P.compare(p1, p3), 1);
    t.checkExpect(P.compare(p4, p2), 0);
    //class PointDistanceCompare
    PointDistanceCompare PD = new PointDistanceCompare();
    t.checkExpect(PD.compare(p1, p2), -1);
    t.checkExpect(PD.compare(p2, p1), 1);
    t.checkExpect(PD.compare(p2, p2), 0);
    t.checkExpect(PD.compare(p1, p3), -1);
    //class StringCompare
    String s1 = "This is x";
    String s2 = "This is z";
    String s2s = "This is z";
    String s3 = "This is xy";
    StringCompare SC = new StringCompare();
    t.checkExpect(SC.compare(s1, s2), -2);
    t.checkExpect(SC.compare(s2s, s2), 0);
    t.checkExpect(SC.compare(s3, s1), 1);
    t.checkExpect(SC.compare(s1, s3), -1);
    //class StringLengthCompare
    StringLengthCompare SLC = new StringLengthCompare();
    t.checkExpect(SLC.compare(s1, s2), 0);
    t.checkExpect(SLC.compare(s2s, s2), 0);
    t.checkExpect(SLC.compare(s2, s3), -1);
    t.checkExpect(SLC.compare(s3, s2), 1);

  }
}
*/
