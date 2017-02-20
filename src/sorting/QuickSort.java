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
		System.out.println("sort:" + low + "," + high);
		if (low < high) {
			int p = partition(dataset, low, high);
			sort(dataset, low, p-1);
			sort(dataset, p+1, high);
		}
		else {
			System.out.println("***");
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
		assert (low < high);
		int pivot = dataset.get(high); // pivot on last
		System.out.println("partition " + low + "-" + high + ":p=" + pivot);
		Sorting.printArray(dataset);
		
		int i = low;
		for (int j = low ; j < high ; j++) {
			System.out.println("> " + dataset.get(j));
			if (dataset.get(j) <= pivot) {
				System.out.println("<");
				swapArrayElements(dataset, i++, j);
				Sorting.printArray(dataset);
				
				Sorting.refresh();
				try {
					Thread.sleep(Sorting.REFRESH_INTERVAL);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		swapArrayElements(dataset, i+1, high);
		try {
			Thread.sleep(Sorting.REFRESH_INTERVAL);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sorting.refresh();
		
		return (i+1);
	}

	private void swapArrayElements(ArrayList<Integer> a, int i, int j) {
		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}
}
