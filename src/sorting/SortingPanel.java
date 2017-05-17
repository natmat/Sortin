package sorting;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SortingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	SortButton sortButton;
	Dimension dimension;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SortingPanel sortingPanel = new SortingPanel(Toolkit.getDefaultToolkit().getScreenSize());
		frame.add(sortingPanel);
		frame.pack();
		frame.setVisible(true);
	}

	public SortingPanel(final Dimension inDimension) {
		this.dimension = new Dimension(inDimension);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));			
		this.setPreferredSize(new Dimension((int)(this.dimension.getWidth()/4), (int)(this.dimension.getHeight()/4)));

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
