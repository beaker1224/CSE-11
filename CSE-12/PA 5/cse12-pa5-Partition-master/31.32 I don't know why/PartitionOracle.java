
// These are some imports that the course staff found useful, feel free to use them
// along with other imports from java.util.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PartitionOracle {

    /**
     * Feel free to use this method to call partition. It catches any exceptions or
     * errors and returns a definitely-invalid pivot (-1) to turn errors into
     * potential failures. For example, in testPartition, you may use
     * 
     * runPartition(p, someArray, someLow, someHigh)
     * 
     * instead of
     * 
     * p.partition(someArray, someLow, someHigh)
     * 
     * @param p
     * @param strs
     * @param low
     * @param high
     * @return
     */
    public static int runPartition(Partitioner p, String[] strs, int low, int high) {
        try {
            return p.partition(strs, low, high);
        } catch (Throwable t) {
            return -1;
        }
    }

    // The three methods below are for you to fill in according to the PA writeup.
    // Feel free to make other helper methods as needed.

/**
error1 = Elements out of the range are modified
error2 = Item before pivot too large
error3 = Item after pivot too small
error4 = Elements within do not match
error5 = pivot is negative
 */
    public static String isValidPartitionResult(String[] before, int low, int high, int pivot, String[] after) {
        String[] bFront = Arrays.copyOfRange(before, 0, low);
        String[] bBack = Arrays.copyOfRange(before, high, before.length);
        String[] aFront = Arrays.copyOfRange(after, 0, low);
        String[] aBack = Arrays.copyOfRange(after, high, after.length);
        String[] be = Arrays.copyOfRange(before, low, high);
        String[] af = Arrays.copyOfRange(after, low, high);

        String error1 = "Elements out of the range are modified";
        String error2 = "Item before pivot too large";
        String error3 = "Item after pivot too small";
        String error4 = "Elements within do not match";
        String error5 = "pivot is negative";
        // compare the front and back, refer to error 1
        if(!Arrays.equals(bFront, aFront) || !Arrays.equals(bBack, aBack)){
            return error1;
        }
        // compare the elements within, refer to error 4
        List<String> a = new ArrayList<>(Arrays.asList(af));
        for(String i:be){
            int index = a.indexOf(i);
            if(index == -1){
                return error4;
            }else{
                a.set(index, null);
            }
        }
        //compare big or small, refer to error 2 and 3
        String[] aFirstHalf = Arrays.copyOfRange(after, low, pivot);
        String[] aSecondHalf = Arrays.copyOfRange(after, pivot, high);
        int p = pivot - low;
        if(p < 0 || p > high - low){return error5;}
        for(String i:aFirstHalf){
            if(i.compareTo(af[p]) > 0){
                return error2;
            }
        }
        for(String i:aSecondHalf){
            if(i.compareTo(af[p]) < 0){
                return error3;
            }
        }

        return null; 
    }

    /**
    * Generate random input of A to Z with string length of n
    */
    public static String[] generateInput(int n) {
        Random r = new Random();
        String[] s = new String[n];

        for (int i = 0; i < n; i++){
            s[i] = Character.toString((char)(r.nextInt(26) + 65));
        }

        return s;
    }

    public static CounterExample findCounterExample(Partitioner p) {
        int low = 1;
        int high = 6;
        String[] before = generateInput(7);
        String[] after = Arrays.copyOf(before, before.length);
        int pivot = p.partition(after, low, high);
        String reason = PartitionOracle.isValidPartitionResult(before, low, high, pivot, after);
        if(reason == null){
            return null;
        }else{
            return new CounterExample(before, low, high, pivot, after, reason);
        }
    }

}
