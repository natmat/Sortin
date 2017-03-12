package sorting;

public class InsertionSort implements ISort {

	public DataSet sort1(DataSet dataset) {
		for (int i = 1 ; i < dataset.data.size() ; i++ ) {
			dataset.setPivot(i);
			int j = i;
			while ((j > 0) && (dataset.data.get(j) < dataset.data.get(j-1))) {
				dataset.swapArrayElements(j-1, j);
				j--;
			}
		}
		return dataset;
	}

	public DataSet sort(DataSet dataset) {
		for (int i = 1 ; i < dataset.data.size() ; i++ ) {
			System.out.print(i + ":");
			Sorting.printArray(dataset.data);
			dataset.setPivot(i);
			int j = i;
			while ((j > 0) && (dataset.data.get(j-1) > dataset.data.get(j))) {
				j--;
			}
			if (j == i) {
				// It's greater
				continue;
			}
			else {
				int insert = dataset.data.get(i);
				System.out.println("Inset:" + insert + " at " + j);
				dataset.data.remove(i);
				dataset.data.add(j, insert);
			}
			Sorting.refresh();
		}
		return dataset;
	}
}
