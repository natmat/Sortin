package sorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Sorting {	
	private final static int RANGE_OF_DATASET = 100;
	private final static int SIZE_OF_DATASET = 200;
	private static ArrayList<Integer> dataset;
	private static JFrame frame;
	private static SortingPanel panel;
	public final static int REFRESH_INTERVAL = 20; 
	private DataSet data;

	public static void main(String[] args) 
			throws InterruptedException, InvocationTargetException {
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
		Sorting s = new Sorting();
		s.data.
		s.generateRandomDataset();

		//		output = new InsertionSort().sort(dataset);
		//		printArray(output);

		sortTheDataset();

		//		frame.dispose();
	}

	public Sorting() {
		data = new DataSet();
		data.newRandomSet();
	}

	private static void sortTheDataset() {
		System.out.println("Sort the dataset");
		DataSet output = new QuickSort().sort(data);
		printArray(output);
	}

	private static class SortingPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		JButton sortButton = new JButton();

		public SortingPanel() {	
			this.setPreferredSize(new Dimension(1000, 800));
			sortButton.setText("Sort");
			sortButton.setActionCommand("sort");
			sortButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sortTheDataset();
				}
			});

			this.add(sortButton);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawHistogram(data);
		}

		public Dimension getPreferredSize() {
			return new Dimension(400,200);
		}
	}

	public static void refresh() {
		frame.repaint();
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

	static void drawHistogram(final ArrayList<Integer>a, Graphics g) {
		g.setColor(Color.RED);

		double step = ((double)frame.getWidth())/a.size();
		double range = ((double)frame.getHeight())/RANGE_OF_DATASET;

		double x = 0f;
		for (Integer i : a) {
			int height = (int) (range*i.intValue());
			g.fillRect((int)(x+step/2), frame.getHeight()-height, (int)step, height); 
			x += step;
		}

		drawSwapLines(g,1,2);
	}

	public static void printArray(final DataSet dataset) {
		final ArrayList<Integer>arr = dataset.data;
		for (int i = 0; i < arr.size() ; i++) {
			System.out.print(arr.get(i) + ",");
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
}

