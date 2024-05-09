// You can (and should) add "implements Partitioner" below once you have the implementation ready
public class FirstElePivotPartitioner implements Partitioner {
	
	public FirstElePivotPartitioner() {}
	
	public int partition(String[] strs, int low, int high) {
		String pivot = strs[low];
		int SmallerBefore = low + 1; 
		int HighAfter = high - 1;
		
		while(SmallerBefore <= HighAfter) {
			if(strs[SmallerBefore].compareTo(pivot) < 0) {
				SmallerBefore += 1;
			}
			else {
				String temp = strs[HighAfter];
				strs[HighAfter] = strs[SmallerBefore];
				strs[SmallerBefore] = temp;						
				HighAfter -= 1;				
			}			
		}
		String temp = strs[HighAfter];
		strs[HighAfter] = pivot;
		strs[low] = temp;
		
		return HighAfter;
	}
}
