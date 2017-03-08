package sorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Sorting {	
	private final static int SIZE_OF_DATASET = 100;
	private static JFrame frame;
	private static SortingPanel panel;
	public final static int REFRESH_INTERVAL = 2; 
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

	static void sortDataset() {
		System.out.println("Sort the dataset");
		new Thread(new Runnable() {

			@Override
			public void run() {
//				DataSet output = new QuickSort().sort(dataset);
				DataSet output = new BubbleSort().sort(dataset);
				printArray(output.data);
			}
		}).start();
	}

	public static void refresh() {
		panel.repaint();
	}

	private static void createAndShowGUI() {
		System.out.println("createAndShowGUI");
		frame = new JFrame("Sort in action");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)(dm.getWidth() - 800)/2, (int)(dm.getHeight() - 200)/2);

		panel = new SortingPanel();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	static void drawHistogram(Graphics g) {
		g.setColor(Color.RED);

		double step = ((double)frame.getWidth())/dataset.data.size();
		double range = ((double)frame.getHeight())/dataset.getRange();

		double x = 0f;
		for (Integer i : dataset.data) {
			int height = (int) (range*i.intValue());
			g.fillRect((int)(x+step/2), frame.getHeight()-height, 
					(int)step, height); 
			x += step;
		}
		drawSwapLines(g,dataset);
	}

	public static void printArray(final ArrayList<Integer> array) {
//		for (int i = 0; i < array.size() ; i++) {
//			System.out.print(array.get(i) + ",");
//		}
//		System.out.println();
	}

	public static void drawSwapLines(Graphics g, DataSet dataset) {
		double step = ((double)frame.getWidth())/dataset.data.size();
		double range = ((double)frame.getHeight())/dataset.getRange();

		int low = dataset.getSwapLow();
		int high = dataset.getSwapHigh();
		int height = frame.getHeight();

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
		Sorting.refresh();
		try {
			Thread.sleep(Sorting.REFRESH_INTERVAL);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

