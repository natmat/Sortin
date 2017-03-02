package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DataSet {
	private final static int RANGE_OF_DATASET = 100;
	private static int dataSize;
	ArrayList<Integer> data;
	private int swapLow;

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

	private int swapHigh;
	private int range;

	public DataSet() {
		range = RANGE_OF_DATASET;
		swapLow = 0;
		swapHigh = 0;
	}
	
	public void newFixedDataset() {
		range = 100;
		data = new ArrayList<>(Arrays.asList(77,58,37,78,53,13,64,15,35,23));
	}
	
	public DataSet(int size) {
		this();
		dataSize = size;
		data = new ArrayList<>(dataSize);
		newRandomSet();
	}

	public DataSet(int size, int range) {
		this();
	}

	public void newRandomSet() {
		Random rand = new Random();
		for (int i = 0 ; i < dataSize; i++) {
			int r = rand.nextInt(this.range);
			data.add(i,  r);
		}
	}

	public int getRange() {
		return(range);
	}
}
