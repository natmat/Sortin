package sorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Sorting {
	private final static int RANGE_OF_DATASET = 100;
	private final static int SIZE_OF_DATASET = 100;
	private static ArrayList<Integer> dataset;
	private static JFrame frame;
	private static SortingPanel panel;

	public static void main(String[] args) 
			throws InterruptedException, InvocationTargetException {
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
		Sorting s = new Sorting();
		s.generateRandomDataset();

		ArrayList<Integer> output = null;		

		output = new InsertionSort().sort(dataset);
		printArray(output);

//		output = new QuickSort().sort(dataset);
//		printArray(output);
		
		frame.dispose();
	}

	private static class SortingPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public SortingPanel() {			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawHistogram(dataset, g);
		}
		
		public Dimension getPreferredSize() {
	        return new Dimension(800,200);
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
		Sorting.refresh();
	}

	public static void printArray(final List<Integer> arr) {
		for (int i = 0; i < arr.size() ; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}

	private void generateRandomDataset() {
		dataset = new ArrayList<>(SIZE_OF_DATASET);
		Random rand = new Random();
		for (int i = 0 ; i < SIZE_OF_DATASET ; i++) {
			int r = rand.nextInt(RANGE_OF_DATASET);
			System.out.print(r + ",");
			dataset.add(i,  r);
		}
		System.out.println("\n");
	}
}

