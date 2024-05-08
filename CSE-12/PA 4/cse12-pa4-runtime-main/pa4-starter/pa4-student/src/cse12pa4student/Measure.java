package cse12pa4student;

import java.util.*;
import java.util.List;
import static cse12pa4mysteries.Mysteries.*;

public class Measure {


	public static List<Measurement> measure(String[] toRun, int startN, int stopN) {
		/** TODO **/
		List<Measurement> L = new ArrayList<>();
		for(String s : toRun){
			for(int i = startN; i <= stopN; i++){
				if(s.equals("A")){
					long startTime = System.nanoTime();
					mysteryA(i);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement result = new Measurement("A", i, estimatedTime);
					L.add(result);
				}
				if(s.equals("B")){
					long startTime = System.nanoTime();
					mysteryB(i);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement result = new Measurement("B", i, estimatedTime);
					L.add(result);
				}
				if(s.equals("C")){
					long startTime = System.nanoTime();
					mysteryC(i);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement result = new Measurement("C", i, estimatedTime);
					L.add(result);
				}
				if(s.equals("D")){
					long startTime = System.nanoTime();
					mysteryD(i);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement result = new Measurement("D", i, estimatedTime);
					L.add(result);
				}
				if(s.equals("E")){
					long startTime = System.nanoTime();
					mysteryE(i);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement result = new Measurement("E", i, estimatedTime);
					L.add(result);
				}
				if(s.equals("F")){
					long startTime = System.nanoTime();
					mysteryF(i);
					long estimatedTime = System.nanoTime() - startTime;
					Measurement result = new Measurement("F", i, estimatedTime);
					L.add(result);
				}
			}
		}
		//Example call to mystery method
		return L;
	}
	

	public static String measurementsToCSV(List<Measurement> toConvert) {

		String result = "name,n,nanoseconds";
		for(Measurement m : toConvert){
			result = result + "\n" + m.name + "," + m.valueOfN + "," + m.nanosecondsToRun;
		}
		return result;
	}
	
	/* Add any helper methods you find useful */
		
}
