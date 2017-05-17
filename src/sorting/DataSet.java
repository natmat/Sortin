package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataSet {
	private final static int RANGE_OF_DATASET = 100;
	private static int dataSize;
	ArrayList<Integer> data;
	private int swapLow;
	private int swapHigh;
	private int pivot;
	private int range;
	private int swapCount;

	public int getSwapLow() {
		return swapLow;
	}

	public void setSwapLow(int swapLow) {
		this.swapLow = swapLow;
	}

	public int getSwapHigh() {
		return swapHigh;
	}

	public void setSwapHigh(int swapHigh) {
		this.swapHigh = swapHigh;
	}

	public DataSet() {
		range = RANGE_OF_DATASET;
		swapLow = 0;
		swapHigh = 0;
		pivot = 0;
	}
	
	public void newFixedDataset() {
		range = 100;
		data = new ArrayList<>(Arrays.asList(77,58,37,78,53,13,64,15,35,23));
	}
	
	public DataSet(int size) {
		this();
		swapCount = 0;
		dataSize = size;
		data = new ArrayList<>(dataSize);
		newRandomSet();
	}

	public DataSet(int size, int range) {
		this();
	}

	public DataSet(final DataSet copyDataSet) {
		data = new ArrayList<>(copyDataSet.data.size());
		for (Integer item : copyDataSet.data) {
			data.add(item); 
		}
	}

	public void newRandomSet() {
		data.clear();
		Random rand = new Random();
		for (int i = 0 ; i < dataSize; i++) {
			int r = rand.nextInt(this.range);
			data.add(i,  r);
		}
//		newFixedDataset();
	}

	public int getRange() {
		return(range);
	}

	public int getPivot() {
		return pivot;
	}

	public void setPivot(int pivot) {
		this.pivot = pivot;
	}
	

	public void swapArrayElements(int i, int j) {
		System.out.println("Swap:" + ++swapCount);
		setSwapLow(i);
		setSwapHigh(j);
		
		Sorting.refresh();
		int tmp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, tmp);
	}

	public void refresh() {
		Sorting.refresh();
		Sorting.pause();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		DataSet o = new DataSet(DataSet.dataSize);
		List<Integer> clone = new ArrayList<>(this.data.size());
		for (int i : this.data) {
			clone.add(i);
		}
		return(clone);
	}
}
