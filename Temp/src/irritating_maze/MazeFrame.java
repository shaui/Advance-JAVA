package irritating_maze;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MazeFrame extends JFrame{

	public static int w = 0;
	public static int h = 0;
	public static BloodStripe bloodStripe;
	public MazeFrame() {
		setTitle("¹q¬y«æ«æ´Î");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,750);
		setLocation((int)(ScreenSize.getX()*0.5)-375,(int)(ScreenSize.getY()*0.5)-375);	
		w = getWidth();
		h = getHeight();
		setLayout(new BorderLayout());
		bloodStripe = new BloodStripe();
		add(bloodStripe, BorderLayout.NORTH);
		add(new IrritatingMaze());
		setVisible(true);
	}
}
