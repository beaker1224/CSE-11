// You can (and should) add "implements Partitioner" below once you have the implementation ready
public class CentralPivotPartitioner implements Partitioner {
	
	
	public int partition(String[] strs, int low, int high) {
		int central = (high + low)/2;
		String central_copy = strs[central];
		strs[central] = strs[low];
		strs[low] = central_copy;
		
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


