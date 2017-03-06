package sorting;

public class QuickSort implements ISort {

	public DataSet sort(DataSet dataset) {
		DataSet output = dataset;
		
//		output = dataset;
//		quicksort1(output, 0, output.size()-1);
//		output = dataset;
//		quicksort2(output, 0, output.size()-1);

		output = dataset;
		Sorting.printArray(dataset.data);
		quicksortHoare(output, 0, output.data.size()-1);
		return(output);
	}

	private void quicksortHoare(DataSet dataset, int first, int last) {
		Sorting.printArray(dataset.data);
		if (first < last) {
			final int mid = partitionHoare(dataset, first, last);
			quicksortHoare(dataset, first, mid-1);
			quicksortHoare(dataset, mid+1, last);
		}
	}

	protected static int partitionHoare(DataSet dataset, int first,int last){
		final int pivot = dataset.data.get(last);
		dataset.setPivot(last);

		int leftCursor = first-1;
		int rightCursor = last;

		while(leftCursor < rightCursor) {
			while (dataset.data.get(++leftCursor) < pivot) {
				dataset.setSwapLow(leftCursor);
				Sorting.refresh();
			};

			while ((leftCursor < rightCursor) && (pivot < dataset.data.get(--rightCursor))) {
				dataset.setSwapLow(rightCursor);
				Sorting.refresh();
			};

			if (leftCursor >= rightCursor) {
				swapArrayElements(dataset, leftCursor, last);
				break;
			}

			swapArrayElements(dataset, leftCursor, rightCursor);
			Sorting.printArray(dataset.data);
		}
		
		return(rightCursor);
	}


	/**
	 * Sort the dataset in situ quickly
	 * @param dataset data to sort 
	 * @param low lower bound index
	 * @param high upper bound index 
	 * @return
	 */
	private void quicksort1(DataSet dataset, int low, int high) {
		System.out.println("sort:" + low + "," + high);
		if (low < high) {
			int p = partition(dataset, low, high);
			quicksort1(dataset, low, p-1);
			quicksort1(dataset, p+1, high);
		}
		else {
			System.out.println("***");
		}
	}

	/**
	 * Partition the array
	 * @param a array to partition
	 * @param low lowest index in a
	 * @param high highest index in a
	 * @return
	 */
	private int partition(DataSet dataset, int low, int high) {
		assert (low < high);
		final int pivot = dataset.data.get(high); // pivot on last
		System.out.println("partition " + low + "-" + high + ":p=" + pivot);
		Sorting.printArray(dataset.data);

		int i = low-1;
		for (int j = low ; j < high-1 ; j++) {
			System.out.println("? " + dataset.data.get(j));
			if (dataset.data.get(j) < pivot) {
				System.out.println("<");
				swapArrayElements(dataset, ++i, j);
			}
		}
		swapArrayElements(dataset, ++i, high);
		Sorting.printArray(dataset.data);
		System.out.println("Return " + i);

		return (i);
	}

	private static void pause(DataSet dataset, int i, int j) {
		Sorting.refresh();
		try {
			Thread.sleep(Sorting.REFRESH_INTERVAL);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void swapArrayElements(DataSet dataset, int i, int j) {
		dataset.setSwapLow(i);
		dataset.setSwapHigh(j);
		
		Sorting.refresh();
		int tmp = dataset.data.get(i);
		dataset.data.set(i, dataset.data.get(j));
		dataset.data.set(j, tmp);

		pause(dataset, i, j);
	}

	private void quicksort2(DataSet data, int p, int r) {
		if (p < r) {              		// nothing to do if the subarray has fewer than 2 elements
			int q = partition(data, p, r); // q is pivot position
			quicksort2(data, p, q-1);       // recursively sort a[p..q-1]
			quicksort2(data, q+1, r);       // recursively sort a[q+1..r]
		}
	}
}


