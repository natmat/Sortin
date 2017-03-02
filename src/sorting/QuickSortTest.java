package sorting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    @Before
    public void executedBeforeEach() {
        System.out.println("@Before: executedBeforeEach");
    }

    @Test
	public void testPartitionHoare_setOfTwo() {
		DataSet dataset = new DataSet();
		dataset.data = new ArrayList<>(Arrays.asList(1,2));
		final int mid = QuickSort.partitionHoare(dataset, 0, 1);
		assertEquals(0, mid);
	}

	public void testPartitionHoare_setOfOne() {
		DataSet dataset = new DataSet();
		dataset.data = new ArrayList<>(Arrays.asList(1));
		final int mid = QuickSort.partitionHoare(dataset, 0, 0);
		assertEquals(1, mid);
	}
}
