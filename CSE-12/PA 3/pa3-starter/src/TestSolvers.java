import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	@Test
	public void diagonalmoves() {
		Maze m1 = new Maze(new String[]{
			"_S_",
			"_#_",
			"F__"
		});
		SearchWorklist q1 = new StackWorklist();
		MazeSolver.solve(m1, q1);
		ArrayList<Square> solution = m1.storePath();
		String[] act = m1.showSolution(solution);
		String[] exp = new String[]{
			"*S_",
			"*#_",
			"F__"
		};
		assertArrayEquals(act,exp);
	}
	
	@Test
	public void stopearly() {
		Maze m1 = new Maze(new String[]{
			"__S",
			"_#_",
			"F__"
		});
		SearchWorklist q1 = new QueueWorklist();
		MazeSolver.solve(m1, q1);
		ArrayList<Square> solution = m1.storePath();
		String[] act = m1.showSolution(solution);
		String[] exp = new String[]{
			"__S",
			"_#*",
			"F**"
		};
		assertArrayEquals(act,exp);
	}
	@Test
	public void difforder() {
		Maze m1 = new Maze(new String[]{
			"___",
			"S#_",
			"F__"
		});
		String[] exp = new String[]{
			"___",
			"S#_",
			"F__"
		};
		checkMaze(new StackWorklist(), m1, exp);

	}
	@Test
	public void test() {
		Maze m1 = new Maze(new String[]{
			"__S",
			"_#_",
			"F__"
		});
		SearchWorklist q1 = new StackWorklist();
		MazeSolver.solve(m1, q1);
		ArrayList<Square> solution = m1.storePath();
		String[] act = m1.showSolution(solution);
		String[] exp = new String[]{
			"**S",
			"*#_",
			"F__"
		};
		assertArrayEquals(act,exp);
	}
}



