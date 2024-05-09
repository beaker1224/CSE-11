// You can (and should) add "implements Partitioner" below once you have the implementation ready
public class CentralPivotPartitioner implements Partitioner{

    public int partition(String[] strs, int low, int high){
        int pivot = (high + low) / 2;
        String Vpivot = strs[pivot];
        strs[pivot] = strs[low];
        strs[low] = Vpivot;
        int smallPointer = low + 1;
        int largePointer = high - 1;

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
        
        return largePointer;

    }
}
