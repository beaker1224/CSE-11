import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class ElementFinder {

	public static int Kth_finder(String filename, int K, String operation) {
		
		// Create a comparator depending upon the type of operation
		Comparator<Integer> comparator = Comparator.naturalOrder();

		if(operation == "largest"){
			comparator = Comparator.naturalOrder();
		}
		if(operation == "smallest"){
			comparator = Comparator.reverseOrder();
		}

		Heap<Integer, Integer> heap = new Heap<Integer, Integer>(comparator);
		/** TODO **/

		try{
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){// check if next line exist
				// advance to next line, break them into strings
				// then turn each string back to number
				String[] input = scanner.nextLine().split(" ");
				for(String s : input){
					heap.add(Integer.parseInt(s), Integer.parseInt(s));
				}
				// all into numbers with order
			}
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
	// now all the numbers from the file are saved to heap
	// return -1 when DNE
	if(K > heap.size()){return -1;}
	int temp = -1;
	for(int i = 0; i < K; i++){
		temp = heap.poll().key;
	}
	return temp;
	}

	/* Add any helper methods you find useful */
		
}
