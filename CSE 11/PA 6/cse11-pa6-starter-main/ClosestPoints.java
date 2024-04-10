class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  boolean belowLeftOf(Point other) {
    return this.x <= other.x && this.y <= other.y;
  }
  boolean aboveRightOf(Point other) {
    return this.x >= other.x && this.y >= other.y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class ClosestPoints{
  public static void main(String[] args) {
    Point p1 = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    Point p2 = new Point(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
    Point p3 = new Point(Integer.parseInt(args[4]), Integer.parseInt(args[5]));
    double distance12 = p1.distance(p2);
    double distance13 = p1.distance(p3);
    double distance23 = p2.distance(p3);
    
    int position = 0;
    double distanceBetween = distance12;
    if (distance13 < distanceBetween){
      distanceBetween = distance13;
      position = 1;
    }
    if (distance23 < distanceBetween){
      distanceBetween = distance23;
      position = 2;
    }

    if(position == 0){
      System.out.println("The closest points are (" + p1.x + ", " + p1.y 
      + ") and (" + p2.x + ", " + p2.y + ") at distance " + distanceBetween);
    }
    if(position == 1){
      System.out.println("The closest points are (" + p1.x + ", " + p1.y 
      + ") and (" + p3.x + ", " + p3.y + ") at distance " + distanceBetween);
    }
    if(position == 2){
      System.out.println("The closest points are (" + p2.x + ", " + p2.y 
      + ") and (" + p3.x + ", " + p3.y + ") at distance " + distanceBetween);
    }
    

  }
}