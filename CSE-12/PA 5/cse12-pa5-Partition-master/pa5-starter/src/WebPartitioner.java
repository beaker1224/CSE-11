// You can (and should) add "implements Partitioner" below once you have the implementation ready

// The license could be found here: https://www.geeksforgeeks.org/legal/copyright-information/
// where it agrees on the part of non-commercial use
// The implementation I found is here: https://www.geeksforgeeks.org/implement-various-types-of-partitions-in-quick-sort-in-java/?ref=header_search
// published by zack_aayush
import java.io.*;
import java.util.*;

public class WebPartitioner implements Partitioner{
    public int Partition(String[] str, int low, int high){//I changed one of the input type into string[]
        String[] temp = new String[high - low + 1]; //I change the variable start to low, and eliminated the ()
        List<String> myList = Arrays.asList(str);
        
        // Choosing a pivot
        String pivot = myList.get(high);
        int index = 0;

        // smaller number
        for (int i = low; i <= high; ++i) {
            if (str[i].compareTo(pivot) < 0){//changed to compareTo()
                temp[index++] = str[i];
            }
        }

        // pivot position
        int position = index;

        // Placing the pivot to its original position
        temp[index++] = pivot;

        for (int i = low; i <= high; ++i){
            if (str[i].compareTo(pivot) > 0)
            {
                temp[index++] = str[i];
            }
        }

        for (int i = low; i <= high; ++i) {
            str[i] = temp[i - low];
        }

        // return the position of the pivot
        return position;
    }
}


 /* this implementation does have a worst case, when the array 
    contains things and the things are different from each other,
    it will go through the entire array and compare
    each value with pivot, it will run x times when have x small
    value and will run (total - x) times for the big value. In this
    case, the tight big-O bound would be O(n).
  */