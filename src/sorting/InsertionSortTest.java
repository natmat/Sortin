package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void test() {
		DataSet dataset = new DataSet(5);
		InsertionSort is = new InsertionSort();
		is.sort(dataset);
		fail("Not yet implemented");
	}

}
