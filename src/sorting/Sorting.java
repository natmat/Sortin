package sorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Sorting {	
	private final static int SIZE_OF_DATASET = 100;
	private static JFrame frame;
	private static SortingPanel panel;
	public final static int REFRESH_INTERVAL = 50; 
	private static DataSet dataset;

	public static void main(String[] args) 
			throws InterruptedException, InvocationTargetException {
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});

		Sorting s = new Sorting();

		//		output = new InsertionSort().sort(dataset);
		//		printArray(output);

		//		s.sortDataset();
		//		frame.dispose();
	}

	public Sorting() {
		newDataset();
	}

	static void sortDataset() {
		System.out.println("Sort the dataset");
		new Thread(new Runnable() {

			@Override
			public void run() {
				DataSet output = new QuickSort().sort(dataset);
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
			g.fillRect((int)(x+step/2), frame.getHeight()-height, (int)step, height); 
			x += step;
		}

		//		drawSwapLines(g,1,2);
	}

	public static void printArray(final ArrayList<Integer> array) {
		for (int i = 0; i < array.size() ; i++) {
			System.out.print(array.get(i) + ",");
		}
		System.out.println();
	}

	public static void drawSwapLines(Graphics g, DataSet dataset) {
		g.setColor(Color.BLACK);

		double step = ((double)frame.getWidth())/dataset.data.size();
		double range = ((double)frame.getHeight())/dataset.getRange();

		int low = dataset.getSwapLow();
		int high = dataset.getSwapHigh();

		g.fillRect((int)(low + step/2), frame.getHeight() - (int)(range*dataset.getSwapLow()), 
				(int)step, dataset.data.get(low));

		g.fillRect((int)(high+ step/2), frame.getHeight() - (int)(range*dataset.getSwapHigh()), 
				(int)step, dataset.data.get(high)); 
	}

	static void newDataset() {
		dataset = new DataSet(SIZE_OF_DATASET);
		dataset.newRandomSet();
		refresh();
	}		
}

