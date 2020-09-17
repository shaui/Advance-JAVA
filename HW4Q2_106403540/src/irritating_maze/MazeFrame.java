package irritating_maze;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import javax.swing.JFrame;

public class MazeFrame extends JFrame{

	public static int w = 0;
	public static int h = 0;
	private Robot r;
	
	public static BloodStripe bloodStripe;
	public MazeFrame() {
		setTitle("�q�y����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,750);
		setLocation((int)(ScreenSize.getX()*0.5)-375,(int)(ScreenSize.getY()*0.5)-375);	
		setLayout(new BorderLayout());
		
		w = getWidth();
		h = getHeight();
		
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
		//set the initial cursor point at the right-down corner
		r.mouseMove((int)(ScreenSize.getX()*0.5)+375, (int)(ScreenSize.getY()*0.5)+375);
		
		bloodStripe = new BloodStripe();
		add(bloodStripe, BorderLayout.NORTH);
		add(new IrritatingMaze());
		setVisible(true);
	}
}
