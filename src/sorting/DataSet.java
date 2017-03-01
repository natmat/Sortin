package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DataSet {
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
		range = 0;
		swapLow = 0;
		swapHigh = 0;
	}
	
	public void newFixedDataset() {
		range = 100;
		data = new ArrayList<>(Arrays.asList(77,58,37,78,53,13,64,15,35,23));
	}
	
	public DataSet(int size) {
		data = new ArrayList<>(size);
	}

	public DataSet(int size, int range) {
		this();
	}

	public void newRandomSet() {
		Random rand = new Random();
		for (int i = 0 ; i < data.size(); i++) {
			int r = rand.nextInt(this.range);
			data.add(i,  r);
		}
	}

	public int getRange() {
		return(range);
	}
}
