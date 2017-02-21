package sorting;

import java.net.DatagramPacket;
import java.util.ArrayList;

public class QuickSort implements ISort {

	@Override
	public ArrayList<Integer> sort(final ArrayList<Integer> dataset) {
		ArrayList<Integer> output = dataset;
//		quicksort(output, 0, output.size()-1);
		quicksort1(output, 0, output.size()-1);
		return(output);
	}

	/**
	 * Sort the dataset in situ quickly
	 * @param dataset data to sort 
	 * @param low lower bound index
	 * @param high upper bound index 
	 * @return
	 */
	private ArrayList<Integer> quicksort(ArrayList<Integer> dataset, int low, int high) {
		System.out.println("sort:" + low + "," + high);
		if (low < high) {
			int p = partition(dataset, low, high);
			quicksort(dataset, low, p-1);
			quicksort(dataset, p+1, high);
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
		final int pivot = dataset.get(high); // pivot on last
		System.out.println("partition " + low + "-" + high + ":p=" + pivot);
		Sorting.printArray(dataset);

		int i = low-1;
		for (int j = low ; j < high-1 ; j++) {
			System.out.println("? " + dataset.get(j));
			if (dataset.get(j) < pivot) {
				System.out.println("<");
				swapArrayElements(dataset, ++i, j);
				pause(dataset);
			}
		}
		swapArrayElements(dataset, ++i, high);
		Sorting.printArray(dataset);
		System.out.println("Return " + i);

		try {
			Thread.sleep(Sorting.REFRESH_INTERVAL);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sorting.refresh();

		return (i);
	}

	private void pause(ArrayList<Integer> dataset) {
		Sorting.printArray(dataset);
		Sorting.refresh();
		try {
			Thread.sleep(Sorting.REFRESH_INTERVAL);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void swapArrayElements(ArrayList<Integer> a, int i, int j) {
		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}

	private void quicksort1(ArrayList<Integer>a, int p, int r) {
		if (p < r) {              		// nothing to do if the subarray has fewer than 2 elements
			int q = partition(a, p, r); // q is pivot position
			quicksort1(a, p, q-1);       // recursively sort a[p..q-1]
			quicksort1(a, q+1, r);       // recursively sort a[q+1..r]
		}
	}

	// Partition a[p..r] into subarrays a[p..q-1] and a[q+1..r], where p <= q <= r, and
	// each element of a[p..q-1] is less than or equal to a[q], which is less than
	// each element of a[q+1..r].
	// Works by selecting the original value of a[r] as the pivot element and
	// partitioning a[p..r] around the pivot.
	// Returns the value of q that marks the partition.
	protected int partition1(ArrayList<Integer>dataset, int p, int r) {
		int pivot = dataset.get(r);        // the value we pivot around
		int i = p - 1;                  // i is index into left side

		// The following for loop maintains the following invariants:
		// 1. Every element of a[p..i] is less than or equal to the pivot.
		// 2. Every element of a[i+1..j-1] is greater than the pivot.
		// 3. a[r] equals the pivot.
		for (int j = p; j < r; j++) {   // j is index into right side
			// Find out which side a[j] goes into.  If the left side, then we have
			// to increment the size of the left side and then get a[j] into position i.
			// If the right side, a[j] is already where we want it, so just incrementing
			// j in the loop header suffices.
			if (dataset.get(i) < pivot) { 	// which side does a[j] go into?
				i++;                    // if left side, make it one larger...
				swap1(dataset, i, j);          // ...and get a[j] into the left side
			}
			pause(dataset);
		}

		// We dropped out of the loop because j == r.  Every element of a[p..i]
		// is less than or equal to the pivot, and every element of a[i+1..r-1] is
		// greater than the pivot.  If we put the pivot into position i+1, then we
		// have what we want: a[p..i] is less than or equal to the pivot, a[i+1]
		// equals the pivot, and a[i+2..r] is greater than the pivot.
		swap1(dataset, i+1, r);
		Sorting.printArray(dataset);

		// Return the index of where the pivot ended up.
		return i+1;
	}

	// Swap two locations i and j in array a.
	protected void swap1(ArrayList<Integer>a, int i, int j) {
		int t = a.get(i);
		a.set(i, a.get(j));
		a.set(j,  t);
	}
}