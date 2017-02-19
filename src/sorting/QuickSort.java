package sorting;

import java.util.ArrayList;

public class QuickSort implements ISort {

	@Override
	public ArrayList<Integer> sort(final ArrayList<Integer> dataset) {
		ArrayList<Integer> output = dataset;
		sort(output, 0, output.size()-1);
		return(output);
	}
	
	/**
	 * Sort the dataset in situ quickly
	 * @param dataset data to sort 
	 * @param low lower bound index
	 * @param high upper bound index 
	 * @return
	 */
	private ArrayList<Integer> sort(ArrayList<Integer> dataset, int low, int high) {
		if (low < high) {
			partition(dataset, low, high);
		}
		return(dataset);
	}

	/**
	 * Partition the array
	 * @param a array to partition
	 * @param low lowest index in a
	 * @param high highest index in a
	 * @return
	 */
	private int partition(ArrayList<Integer>dataset, int low, int high) {
		int pivot = dataset.get(high); // pivot on last
		int i = low - 1;
		for (int j = low ; j < high ; j++) {
			if (dataset.get(j) <= pivot) {
				i++;
				swapArrayElements(dataset, i, j);
			}
		}
		return high;
	}

	private void swapArrayElements(ArrayList<Integer> a, int i, int j) {
		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}
}
