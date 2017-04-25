package sorting;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Sorting {	
	private final static int SIZE_OF_DATASET = 100;
	private static SortingFrame sortingFrame;
	private static SortingPanel panel;
	public final static int REFRESH_INTERVAL = 20; 
	private static DataSet dataset;

	public static void main(String[] args) 
			throws InterruptedException, InvocationTargetException {
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});

		//		Sorting s = new Sorting();
		Sorting.newDataset();

		//		output = new InsertionSort().sort(dataset);
		//		printArray(output);

		//		s.sortDataset();
		//		frame.dispose();
	}

	public Sorting() {
	}

	static void sortDataset(int sort) {
		System.out.println("Sort the dataset");
		new Thread(new Runnable() {

			@Override
			public void run() {
				DataSet output = null;
				switch(sort) {
				case 0:
					output = new QuickSort().sort(dataset);
					break;
				case 1:
//					output = new BubbleSort().sort(dataset);
//					break;
				case 2:
					output = new InsertionSort().sort(dataset);
					break;
				}
				printArray(output.data);
			}
		}).start();
	}

	public static void refresh() {
		panel.repaint();
		Sorting.pause();
	}

	private static void createAndShowGUI() {
		System.out.println("createAndShowGUI");
		sortingFrame = new SortingFrame("Sort in action");
		sortingFrame.pack();
		sortingFrame.setVisible(true);
	}

	static void drawHistogram(Graphics g) {
		g.setColor(Color.RED);

		double step = ((double)sortingFrame.getWidth())/dataset.data.size();
		double range = ((double)sortingFrame.getHeight())/dataset.getRange();

		double x = 0f;		
		for (Integer i : dataset.data) {
			int height = (int) (range*i.intValue());
			g.fillRect((int)(x+step/2), sortingFrame.getHeight()-height, 
					(int)step, height); 
			x += step;
		}
		drawSwapLines(g,dataset);
	}

	public static void printArray(final ArrayList<Integer> array) {
		for (int i = 0; i < array.size() ; i++) {
			System.out.print(array.get(i) + ",");
		}
		System.out.println();
	}

	public static void drawSwapLines(Graphics g, DataSet dataset) {
		double step = ((double)sortingFrame.getWidth())/dataset.data.size();
		double range = ((double)sortingFrame.getHeight())/dataset.getRange();

		int low = dataset.getSwapLow();
		int high = dataset.getSwapHigh();
		int height = sortingFrame.getHeight();

		g.setColor(Color.BLACK);
		g.fillRect(0,  
				height - (int)(range*dataset.data.get(dataset.getPivot())),
				(int)(step*(dataset.getPivot() + 0.5)), 1); 

		g.setColor(Color.GREEN);
		g.fillRect((int)(step*(low + 0.5)), height - (int)(range*dataset.data.get(low)),
				(int)step, height); 

		g.setColor(Color.YELLOW);
		g.fillRect((int)(step*(high+ 0.5)), height - (int)(range*dataset.data.get(high)),
				(int)step, height); 

		g.setColor(Color.BLACK);
		g.fillRect((int)(step*(dataset.getPivot())), 
				height - (int)(range*dataset.data.get(dataset.getPivot())),
				(int)step, height); 

	}

	static void newDataset() {
		dataset = new DataSet(SIZE_OF_DATASET);
		dataset.newRandomSet();
		refresh();
	}

	public static void pause() {
		try {
			Thread.sleep(Sorting.REFRESH_INTERVAL);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

