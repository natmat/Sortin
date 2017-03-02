package sorting;

public class InsertionSort implements ISort {
	
	private static DataSet dataset = null;

	@Override
	public DataSet sort(final DataSet inDataset) throws InterruptedException {
		dataset = inDataset;
		for (int i = 1 ; i < dataset.data.size() ; i++) {
			int j = i;
			while (j > 0) {
				if (dataset.data.get(j) < dataset.data.get(j-1)) {
					swapWithPrevious(j);
				}
				j--;
			}
			Thread.sleep(Sorting.REFRESH_INTERVAL);
			Sorting.refresh();
		}
		Sorting.refresh();
		return(dataset);
	}

	private void swapWithPrevious(int j) {
		int tmp = dataset.data.get(j);
		dataset.data.set(j,  dataset.data.get(j-1));
		dataset.data.set(j-1, tmp);
	}
}
