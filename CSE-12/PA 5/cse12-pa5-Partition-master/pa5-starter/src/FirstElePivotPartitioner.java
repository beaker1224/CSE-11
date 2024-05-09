// You can (and should) add "implements Partitioner" below once you have the implementation ready
public class FirstElePivotPartitioner {
//from lecture sort quickly
    public int partition(String[] strs, int low, int high){
        int pivot = low;
        String Vpivot = strs[pivot];
        int smallPointer = low + 1;
        int largePointer = high - 1; //since high is length

        while(smallPointer <= largePointer){
            if(strs[smallPointer].compareTo(Vpivot) < 0){
                smallPointer ++;
            }
            else{// the front is bigger than the last, swap
                String temp = strs[largePointer];
                strs[largePointer] = strs[smallPointer];
                strs[smallPointer] = temp;
                largePointer --;
            }
        }
        String temp = strs[largePointer];
        strs[largePointer] = Vpivot;
        strs[low] = temp;
        
        return largePointer; //which is the current position of the pivot
    }
}
