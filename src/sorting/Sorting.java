package sorting;

import java.awt.Color;
import java.awt.Graphics;
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
	private static SortingFrame view;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
		Sorting s = new Sorting();
		SortingFrame sv = new SortingFrame();

		//		ArrayList<Integer> output = s.insertSort();
		//		showArray(output);
	}

	private static void createAndShowGUI() {
		view = new SortingFrame();
	}

	private static class SortingFrame extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SortingFrame() {
			setTitle("Sort in action");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(200, 200);
			setLocationRelativeTo(null);

			JPanel panel = new JPanel() {
				private static final long serialVersionUID = 1L;
				@Override
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					drawHistogram(dataset, g);
				}
			};
			add(panel);

			setVisible(true);
		}

		private void drawHistogram(final ArrayList<Integer>a, Graphics g) {
			System.out.println("drawHistogram");
			
			g.setColor(Color.RED);
			
			double step = ((double)getWidth())/a.size();
			double range = ((double)getHeight())/RANGE_OF_DATASET;

			double x = 0f;
			for (Integer i : a) {
				int height = (int) (range*i.intValue());
				g.fillRect((int)(x+step/2), getHeight()-height, (int)step, height); 
				x += step;
			}
		}
	}


	private static void showArray(final List<Integer> arr) {
		for (int i = 0; i < arr.size() ; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println("\n");
	}

	private ArrayList<Integer> insertSort() {
		for (int i = 1 ; i < dataset.size() ; i++) {
			System.out.print("Testing " + dataset.get(i) + ": ");
			showArray(dataset);
			int j = i;
			while (j > 0) {
				if (dataset.get(j) < dataset.get(j-1)) {
					swapWithPrevious(j);
				}
				j--;
			}
		}
		return(dataset);
	}

	private void swapWithPrevious(int j) {
		int tmp = dataset.get(j);
		dataset.set(j,  dataset.get(j-1));
		dataset.set(j-1, tmp);
	}

	public Sorting() {
		generateRandomDataset();
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

	private void quickSort(ArrayList<Integer> a, int low, int high) {
		if (low < high) {
			partition(a, low, high);
		}
	}

	/**
	 * Partition the array
	 * @param a array to partition
	 * @param low lowest index in a
	 * @param high highest index in a
	 * @return
	 */
	private int partition(ArrayList<Integer>a, int low, int high) {
		int pivot = a.get(high); // pivot on last
		int i = low - 1;
		for (int j = low ; j < high ; j++) {
			if (a.get(j) <= pivot) {
				i++;
				swapArrayElements(a, i, j);
			}
		}
		return high;
	}

	private void swapArrayElements(ArrayList<Integer> a, int i, int j) {
		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}
}
