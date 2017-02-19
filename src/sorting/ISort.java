package sorting;

import java.util.ArrayList;

public interface ISort {

	/**
	 * Return numerically sorted set of the input dataset
	 * @param dataset input dataset to sort
	 * @return sorted dataset
	 * @throws InterruptedException
	 */
	ArrayList<Integer> sort(final ArrayList<Integer> dataset) throws InterruptedException;
	
}
