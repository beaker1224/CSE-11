import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * This is an example of how to implement the Partitioner interface to implement
 * a concrete Partitioner. You can use this bad implementation to test your PartitionOracle,
 * to ensure that it works in detecting a bad Partitioner. You should add a correct implementation
 * of a Partitioner here, maybe one from class, to verify that your PartitionOracle also works
 * correctly on good implementations. Once you implement part 2, you can also test those Partitioner
 * implementations here as well.
 * 
 */
class CopyFirstElementPartition implements Partitioner {
    public int partition(String[] strs, int low, int high) {
        if (high - low < 1)
            return 0;
        for (int i = 0; i < strs.length; i += 1) {
            strs[i] = strs[0];
        }
        return 0;
    }
}

public class TestPartitionOracle {
	
	@Test
	public void testIsvalid1(){
		
		String[] bef = {"a","b","d","c"};
		String[] aft = {"a","b","c","d"};
		
		assertNull(PartitionOracle.isValidPartitionResult(bef, 0, 4,0, aft));		
	}
	@Test
	public void testIsvalid2(){
		
		String[] bef = {"dsfhji","a","b","d","c","dsfhji"};
		String[] aft = {"dsfhji","a","b","c","d","dsfhji"};
		
		assertNull(PartitionOracle.isValidPartitionResult(bef, 1, 5, 4, aft));		
	}
	
	@Test
	public void testIsvalid3(){
		
		String[] bef = {"a","b","d","c","e"};
		String[] aft = {"a","c","b","d","e"};
		
		assertNull(PartitionOracle.isValidPartitionResult(bef, 0, 5, 3, aft));		
	}
	
	@Test
	public void testIsvalid4(){
		
		String[] bef = {"A","A","A"};
		String[] aft = {"A","A","A"};
		
		assertNull(PartitionOracle.isValidPartitionResult(bef, 0, 2, 1, aft));		
	}
	
	@Test
	public void testIsvalid5(){
		
		String[] bef = {"A","B","C"};
		String[] aft = {"A","B","C"};
		
		assertNull(PartitionOracle.isValidPartitionResult(bef, 0, 3,2, aft));		
	}
	
	@Test
	public void testGenerateinput(){
		int n = 10;
		String[] test = PartitionOracle.generateInput(n);
		assertEquals(n,test.length);	
	}
	
	@Test
	public void testGenerateinput2(){
		int n = 100;
		String[] test = PartitionOracle.generateInput(n);
		assertEquals(n,test.length);
	}
	
	
	
	@Test
	public void FEpartition1(){
		Partitioner p = new FirstElePivotPartitioner();
		
		CounterExample test= PartitionOracle.findCounterExample(p);
		assertNull(test);
	}
	
	@Test
	public void FEpartition2(){
		Partitioner p2 = new FirstElePivotPartitioner();
		
		CounterExample test= PartitionOracle.findCounterExample(p2);	
		assertNull(test);
	}
	
	@Test
	public void CEpartition1(){
		Partitioner p = new CentralPivotPartitioner();
		
		CounterExample test= PartitionOracle.findCounterExample(p);	
		assertNull(test);
	}
	
	@Test
	public void CEpartition2(){
		Partitioner p = new CentralPivotPartitioner();
		
		CounterExample test= PartitionOracle.findCounterExample(p);	
		assertNull(test);
	}
	
	@Test
	public void CEpartition3(){
		Partitioner p = new CentralPivotPartitioner();
		
		CounterExample test= PartitionOracle.findCounterExample(p);	
		System.out.println(test);
		assertNull(test);
	}
	
	
	
    @Test
    public void testCopyFirstElementPartition() {
        CounterExample ce = PartitionOracle.findCounterExample(new CopyFirstElementPartition());
        System.out.println(ce);
        assertNotNull(ce);
    }

}
