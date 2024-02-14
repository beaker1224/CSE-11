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
//Method 4 -------------------------------------------------------
  Pair addMulti(int[] input){
    int a = 0;
    int b = 1;
    for(int i = 0; i < input.length; i++){
      a = a + input[i];
      b = b * input[i];
    }
    return new Pair(a, b);
  }
//test -----------------------------------------------------------
  void testaddMulti(Tester t){
    int[] input1 = {0,2,4};
    int[] input2 = {1,5,7,3};
    int[] input3 = {3,4,1};

    t.checkExpect(addMulti(input1).a, 6);
    t.checkExpect(addMulti(input1).b, 0);
    t.checkExpect(addMulti(input2).a, 16);
    t.checkExpect(addMulti(input2).b, 105);
    t.checkExpect(addMulti(input3).a, 8);
    t.checkExpect(addMulti(input3).b, 12);
  }
//Method -----------------------------------------------------------
  String lastSortedString(String[] input){
    String last = input[0];
    if(input.length > 1){
      for(int i = 0; i < input.length - 1; i++){
        if(input[i + 1].compareTo(input[i]) > 0){
          last = input[i + 1];
        }
      }
      return last;
    }
    return input[0];
  }
//test --------------------------------------------------------------
  void testlastSortedString(Tester t){
    String[] input1 = {"hello"};
    String[] input2 = {"hello", "world"};
    String[] input3 = {"apple", "banana", "Apple"};
    
    t.checkExpect(lastSortedString(input1), "hello");
    t.checkExpect(lastSortedString(input2), "world");
    t.checkExpect(lastSortedString(input3), "banana");
  }
//Method -----------------------------------------------------------
  int lookup(String[] keys, int[] values, String key){
    int position = -1;
    for(int i = 0; i < keys.length - 1; i++){
      if(keys[i].compareTo(key) == 0){
        if(i > values.length){
          return -1;
        }
        position = values[i];
      }
    }
    return position;
  }
//test ------------------------------------------------------------
  void testlookup(Tester t){
    String[] keys1 = {"UCSD", "UCLA", "UCI", "Stanford"};
    int[] values1 = {36000, 44900, 33467};

    t.checkExpect(lookup(keys1, values1, "UCSD"), 36000);
    t.checkExpect(lookup(keys1, values1, "UCI"), 33467);
    t.checkExpect(lookup(keys1, values1, "Stanford"), -1);
  }
}