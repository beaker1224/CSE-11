import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.*;

public class BSTTest {
	@Test
	public void testPutNull() {
		BST<String, Integer> test1 = new BST<>();
		test1.put("2", 2);
		test1.put("5", null);
		assertFalse(test1.put("2", 9));
		assertFalse(test1.put("2", null));
	}

	@Test
	public void testOrder() {
		BST<String, Integer> test2 = new BST<>();
		test2.put("b", 2);
		test2.put("e", 5);
		test2.put("a", 1);
		assertEquals(3, test2.keys().size());
		assertEquals("a", test2.keys().get(0));
	}
}
