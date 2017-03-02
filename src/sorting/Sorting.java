package sorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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
	private final static int SIZE_OF_DATASET = 20;
	private static JFrame frame;
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
		
		Sorting s = new Sorting();

//		output = new InsertionSort().sort(dataset);
//		printArray(output);

//		s.sortDataset();

//		frame.dispose();
	}

	public Sorting() {
		newDataset();
	}

	private static void sortDataset() {
		System.out.println("Sort the dataset");
		DataSet output = new QuickSort().sort(dataset);
		printArray(output.data);
	}

	private static class SortingPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		SortButton sortButton;

		public SortingPanel() {	
			this.setPreferredSize(new Dimension(1000, 800));
			sortButton = new SortButton();
			sortButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("SortButton pressed");
					sortButton.pressed();
				}
			});

			this.add(sortButton);
		}
		
		private static class SortButton extends JButton {
			private static final long serialVersionUID = 1L;
			private static boolean state;
			
			public SortButton() {
				state = false;
				setText("New Data");
			}
			
			private void pressed() {
				if (state == false) {				
					setText("Sort");
					state = true;
					Sorting.newDataset();
				}
				else {
					setText("New Data");
					state = false;
					Sorting.sortDataset();
				}
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawHistogram(g);
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

	private static void drawHistogram(Graphics g) {
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
	
	private static void newDataset() {
		dataset = new DataSet(SIZE_OF_DATASET);
		dataset.newRandomSet();
		refresh();
	}		
}

