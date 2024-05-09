
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

    public static String isValidPartitionResult(String[] before, int low, int high, int pivot, String[] after) {
    	
    	String[] b1 = Arrays.copyOfRange(before, 0, low);  	
    	String[] a1 = Arrays.copyOfRange(after, 0, low);
    	String[] b2 = Arrays.copyOfRange(before, high, before.length);
    	String[] a2 = Arrays.copyOfRange(after, high, after.length);
    	
        if((!Arrays.equals(b1, a1) || !Arrays.equals(b2, a2))) {
    		return "Elements do not match";
    	}
    	
    	String[] bef = Arrays.copyOfRange(before, low, high);
    	String[] aft = Arrays.copyOfRange(after, low, high);
    	
    	
    	List<String> c = new ArrayList<>(Arrays.asList(aft));
    	
    	for(String i:bef) {
    		
    		int index = c.indexOf(i);
    		if(index == -1) {
    			return "After array does not have the same elements";
    		}
    		else { 
    			c.set(index,null);} 		
    	}
    	
    	int real_pivot = pivot - low;
    	for(int i =0; i < real_pivot; i++) {
    		if (aft[i].compareTo(aft[real_pivot]) > 0){
    			return "Index before pivot too large";			
    		}		
    	}
    	
    	if(pivot < 0) {return "negative pivot";}
    	for(int i = pivot; i < aft.length; i++) {
    		if (aft[i].compareTo(aft[real_pivot]) < 0){
    			return "Index after pivot too small";			
    		}   		
    	}
    	
        return null;
    }

    public static String[] generateInput(int n) {
    	Random r = new Random();
    	
    	String[] result = new String[n];
    	for ( int i = 0; i < result.length; i++) {
  	
    	int asciiForACapLetter = r.nextInt(26) + 65;  // Generates a random letter from A - Z
    	String s = Character.toString((char)(asciiForACapLetter));
    	result[i] = s;
    	}
    	
        return result;
    }

    public static CounterExample findCounterExample(Partitioner p) {
		int low = 1;
		int high = 4;
		
		String[] before = PartitionOracle.generateInput(5);
		String[] after = Arrays.copyOf(before, before.length);
		int pivot = p.partition(after, low, high);
		
		String reason = PartitionOracle.isValidPartitionResult(before, low, high, pivot, after);
		if( reason == null) {
			return null;
		}
		else {		
			return new CounterExample(before,low, high, pivot, after, reason);
		}
		
				
	}

}
