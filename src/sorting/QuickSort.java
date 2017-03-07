package sorting;

public class QuickSort implements ISort {

	public DataSet sort(DataSet dataset) {
		DataSet output = dataset;
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
			while (dataset.data.get(++leftCursor) < pivot);

			while ((leftCursor < rightCursor) && (pivot < dataset.data.get(--rightCursor)));

			if (leftCursor >= rightCursor) {
				swapArrayElements(dataset, leftCursor, last);
				break;
			}

			swapArrayElements(dataset, leftCursor, rightCursor);
			Sorting.printArray(dataset.data);
		}
		
		return(rightCursor);
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
}


