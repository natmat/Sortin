package sorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SortingFrame extends JFrame {
	public static void main(String[] args) {
		String[] a = new String[] {"AB","BC","CD","AE"};
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(a));
		System.out.println("AB:" + Arrays.asList(a).contains("AB"));
		System.out.println("AB:" + al.contains("AB"));
	
		SortingFrame frame = new SortingFrame();
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
	
	public SortingFrame() {
		super();
		init();
	}
	
	private void init() {
		setTitle("Sort in action");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(dm.getWidth() - 800)/2, (int)(dm.getHeight() - 200)/2);
		setSize(dm.width/2, dm.height/2);
		setLayout(new GridLayout(0, 2));
		
		for (int i = 0 ; i < 4 ; i++) {
			JPanel p = new JPanel();
			p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			p.setPreferredSize(new Dimension(200, 200));
			this.add(p);
		}

		// Add four sorting panels
//		panel = new SortingPanel();
//		sortingFrame.add(panel);
//		sortingFrame.pack();
//		sortingFrame.setVisible(true);

		pack();
	}
}