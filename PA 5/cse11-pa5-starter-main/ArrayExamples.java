import java.util.Arrays;

import tester.*;

class Pair{
  int a, b;
//Constructor ----------------------------------------------------
  Pair(int a, int b){
    this.a = a;
    this.b = b;
  }
  
}

class ArrayExamples{
//Method 1 ---------------------------------------------------------------
  String reverseJoinWith(String[] input, String separator){
    String concatinated = "";
    for (int i = 1; i <= input.length; i++){
      if( i < input.length){      
        concatinated = concatinated + input[input.length - i] + separator;
      } else {
        concatinated = concatinated + input[input.length - i];
      }
    }
    return concatinated;
  } 
//tests
  void testArrayExamples(Tester t){
    String[] input1 = {"a", "b", "c", "d"};
    String[] input2 = {"!", "interesting", "is", "This"};
    String[] input3 = {"zero", "is", "separater", "The"};

    t.checkExpect(this.reverseJoinWith(input1, ":"), "d:c:b:a");
    t.checkExpect(this.reverseJoinWith(input2, " "), "This is interesting !");
    t.checkExpect(this.reverseJoinWith(input3, "0"), "The0separater0is0zero");
  }
//Method 2 ---------------------------------------------------------- 
  boolean logicalOr(boolean[] TOF){
    if (TOF.length > 0){
      for (int i = 0; i < TOF.length; i++){
        if (TOF[i] == true){
          if(i == TOF.length - 1){
            return true;
          }
          continue;
        }
        return false;
      }
    }
      return false;
  }
//test --------------------------------------------------------------
  void testlogicalOr(Tester t){
    boolean[] input1 = {true, false, true, false};
    boolean[] input2 = {};
    boolean[] input3 = {true, true, true, true};

    t.checkExpect(logicalOr(input1), false);
    t.checkExpect(logicalOr(input2), false);
    t.checkExpect(logicalOr(input3), true);
  }
//Method 3 ----------------------------------------------------------
  boolean allOutsideRange(double[] input, double low, double high){
    if(input.length > 0){
      for(int i = 0; i < input.length; i++){
        if(input[i] <= high && input[i] >= low){
          return false;
        }
      }
      return true;
    }
    return true;
  }
//test ----------------------------------------------------------
  void testallOutsideRange(Tester t){
    double[] input1 = {};
    double[] input2 = {5, 5, 5, 5};
    double[] input3 = {17, -1, -3, 11, 10.1, 0};

    t.checkExpect(allOutsideRange(input1, 5.0, 10.0), true);
    t.checkExpect(allOutsideRange(input2, 5.0, 5.0), false);
    t.checkExpect(allOutsideRange(input3, 3, 10), true);
  }
}



