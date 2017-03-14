package sorting;

public class InsertionSort implements ISort {

	public DataSet sort(DataSet dataset) {
		for (int i = 1 ; i < dataset.data.size() ; i++ ) {
			int pivot = dataset.data.get(i);
			dataset.setPivot(pivot);
			int j = i;
			while ((j > 0) && (dataset.data.get(j-1) > dataset.data.get(j))) {
				dataset.data.set(j, dataset.data.get(j-1));
				j--;
			}
			dataset.data.set(j, pivot);
			Sorting.refresh();
		}
		return dataset;
	}

	public DataSet sort2(DataSet dataset) {
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
