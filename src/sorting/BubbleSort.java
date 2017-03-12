package sorting;

public class BubbleSort implements ISort {

	public DataSet sort(DataSet dataset) {
		DataSet output = dataset;
		if (dataset.data.size() < 2) {
			return(output);
		}

		for (int i = 1 ; i < dataset.data.size() ; i++) {
			for (int j = 0 ; j < (dataset.data.size()-i) ; j++) {
				if (dataset.data.get(j) > dataset.data.get(j+1)) {
					dataset.swapArrayElements(j, j+1);
				}
			}
		}		
		return(output);
	}
}
