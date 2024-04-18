import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}

	@Test
	public void chaffAlwaysChoosesFirstArrayGL() {
		String[] input = {"benzene","goat","is","starboy"};
		ArrayGL<String> strAGL = new ArrayGL<>(input);
		strAGL.chooseAll(new LongWordChooser());
		assertEquals(true, strAGL.size == 2);
	}

	@Test
	public void chaffChooseAllFailsIfLastNotChosenLinkedGL() {
		String[] input = {"benzene","goat","is","starboy"};
		String[] exp = {"benzene", "starboy"};
		MyList<String> strAGL = new LinkedGL<>(input);
		strAGL.chooseAll(new LongWordChooser());
		assertArrayEquals(strAGL.toArray(), exp);
	}

	@Test
	public void chaffDoWhileToArrayLinkedGL() {
		String[] str = {};
		LinkedGL<String> s = new LinkedGL<>(str);
		assertEquals(true, Arrays.equals(str, s.toArray()));
	}

	@Test
	public void chaffDoWhileTransformArrayGL() {
		String[] s1 = {"a","b","c","d"};
		String[] s2 = {"A", "B", "C", "D"};
		MyList<String> s = new ArrayGL<>(s1);
		MyTransformer mt = new UpperCaseTransformer();
		s.transformAll(mt);
		assertArrayEquals(s.toArray(), s2);
	}

	@Test
	public void chaffFixedSizeConstructorLinkedGL() {
		String[] s = new String[50];
		for(int i = 0; i < 50; i++){s[i] = "sleep";}
		MyList<String> str = new LinkedGL<>(s);
		assertArrayEquals(s, str.toArray());
	}

	@Test
	public void chaffIncludeNullToArrayArrayGL() {
		String[] str = {null, null, null,"d"};
		String[] exp = {"d"};
		MyList<String> s = new ArrayGL<>(str);
		s.chooseAll(new NoCc());
		assertArrayEquals(exp, s.toArray());
	}

	@Test
	public void chaffIncorrectTransformBoundsLinkedGL() {
		String[] s1 = {"a","b","c","d"};
		String[] s2 = {"A", "B", "C", "D"};
		MyList<String> s = new LinkedGL<>(s1);
		MyTransformer mt = new UpperCaseTransformer();
		s.transformAll(mt);
		assertArrayEquals(s.toArray(), s2);
	}

	@Test
	public void chaffIsEmptyReturnsFalseSizeGreaterThan3() {
		String[] str = {"","","","","","",""};
		MyList<String> s = new ArrayGL<>(str);
		MyList<String> l = new LinkedGL<>(str);
		assertEquals(false, l.isEmpty());
		assertEquals(false, s.isEmpty());
	}


	@Test
	public void chaffIsEmptyReturnsTrueIfSizeGreateThan0ArrayGL() {
		String[] input = {"benzene","goat","is","starboy"};
		MyList<String> strAGL = new ArrayGL<>(input);
		assertEquals(false, strAGL.isEmpty());
	}


	@Test
	public void chaffReturnNewArrayArrayGL() {
		String[] input = {"benzene","goat","is","starboy"};
		MyList<String> in = new ArrayGL<>(input);
		assertArrayEquals(input, in.toArray());
	}
}