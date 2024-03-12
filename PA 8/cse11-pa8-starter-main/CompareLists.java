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
  double Distance(Point p){
    return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
  }

  public int compare(Point p1, Point p2){
    if(Distance(p1) < Distance(p2)){
      return -1;
    }else if(Distance(p1) == Distance(p2)){
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
    else{ return 1; }
  }
}

class BooleanCompare implements Comparator<Boolean>{

}

class Examples implements Comparator<Boolean>{
  void testExamples(Tester t){
    t.checkExpect();
  }
}