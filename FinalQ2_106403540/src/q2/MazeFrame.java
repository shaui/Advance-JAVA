package q2;

import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.JFrame;


public class MazeFrame extends JFrame{
	//Frame size
	public static int w = 0;
	public static int h = 0;
	
	//cursor 
	private Robot r;
	
	//component
	private BasePanel basePanel;
	public static BloodStripe bloodStripe;
	
	public MazeFrame() {
		//Basic set
		setTitle("電流急急棒");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,750);
		setLocation((int)(ScreenSize.getX()*0.5)-375,(int)(ScreenSize.getY()*0.5)-375);	
		setLayout(null);
		
		//get the frame size
		w = getWidth();
		h = getHeight();
		
		//new the cursor
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		//set the initial cursor point at the right-down corner
		r.mouseMove((int)(ScreenSize.getX()*0.5)+375, (int)(ScreenSize.getY()*0.5)+375);
		
		//base Maze
		basePanel = new BasePanel();
		basePanel.setBounds(0, 0, w-20, h-30);
		add(basePanel);
		setVisible(true);
		
	}
}
