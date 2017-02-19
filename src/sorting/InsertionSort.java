package sorting;

import java.util.ArrayList;

public class InsertionSort implements ISort {
	
	private static ArrayList<Integer> dataset = null;

	@Override
	public ArrayList<Integer> sort(final ArrayList<Integer> inDataset) throws InterruptedException {
		dataset = inDataset;
		for (int i = 1 ; i < dataset.size() ; i++) {
//			System.out.print("\nTesting " + dataset.get(i) + ": ");
//			Sorting.printArray(dataset);
			
			int j = i;
			while (j > 0) {
				if (dataset.get(j) < dataset.get(j-1)) {
					swapWithPrevious(j);
				}
				j--;
			}
			Thread.sleep(50);
			Sorting.refresh();
		}
		Sorting.refresh();
		return(dataset);
	}

	private void swapWithPrevious(int j) {
		int tmp = dataset.get(j);
		dataset.set(j,  dataset.get(j-1));
		dataset.set(j-1, tmp);
	}
}
