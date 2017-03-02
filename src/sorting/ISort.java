package sorting;

public interface ISort {

	/**
	 * Return numerically sorted set of the input dataset
	 * @param dataset input dataset to sort
	 * @return sorted dataset
	 * @throws InterruptedException
	 */
	DataSet sort(final DataSet dataset) throws InterruptedException;
	
}
