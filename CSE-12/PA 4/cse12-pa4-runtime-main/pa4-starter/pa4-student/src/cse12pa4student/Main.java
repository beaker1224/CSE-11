package cse12pa4student;
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		List<Measurement> L = Measure.measure(new String[] {"A"}, 0, 100);
		System.out.println(Measure.measurementsToCSV(L));
	}
}
