package sorting;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class SortingFrame extends JFrame {
	
	public static void main(String[] args) {
		SortingFrame frame = new SortingFrame("SortingFrame.main()");
		frame.setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6432175466346993821L;

	public SortingFrame(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setTitle("Sort in action");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(screenSize.getWidth()*1/4), (int)(screenSize.getHeight()*1/4));
		setSize(screenSize.width/2, screenSize.height/2);
		setLocationRelativeTo(null);
		
		// Create 2x2 panels	.
		setLayout(new GridLayout(0, 2));
		for (int i = 0 ; i < 4 ; i++) {
			SortingPanel sortingPanel = new SortingPanel(screenSize);
			this.add(sortingPanel);
		}
	}
}