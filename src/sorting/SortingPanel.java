package sorting;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SortingPanel extends JPanel {
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
		private static int sort; 

		public SortButton() {
			state = false;
			setText("New Data");
			sort = 0;
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
				Sorting.sortDataset(sort++);
				sort = (sort > 2) ? 0 : sort;
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Sorting.drawHistogram(g);
	}

	public Dimension getPreferredSize() {
		return new Dimension(400,200);
	}
}
