package irritating_maze;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
