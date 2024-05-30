// import static org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

/**
 * HeapTest class implements tester that will test the methods from heap file
 */
public class HeapTest {

	@Test
	public void testAdd() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19,"");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		assertEquals(8, heap.entries.size());

	}

	@Test
	public void testPeek() {
		Comparator<Integer> maxHeapComparator = Comparator.naturalOrder();

		Heap<Integer, Integer> heap = new Heap<Integer, Integer>(maxHeapComparator);
		heap.add(19, 19);
		heap.add(50, 50);
		heap.add(30, 30);
		heap.add(15, 15);
		heap.add(20, 20);
		assertEquals(5, heap.entries.size());
		heap.poll();
		assertEquals(4, heap.entries.size());
		int peek = heap.peek().key;
		assertEquals(peek, 30);

	}
}