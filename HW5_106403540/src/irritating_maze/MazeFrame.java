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
	
	//The picture to move on the screen
	private Icon monicaA = new ImageIcon(getClass().getResource("monicaA.jpg"));
	private Icon monicaB = new ImageIcon(getClass().getResource("monicaB.png"));
	private Icon monicaC = new ImageIcon(getClass().getResource("monicaC.jpg"));
	
	//move component
	private JPanel monica;
	private JLabel pic;
	
	//thread pool
	public static ScheduledExecutorService monicaPool;
	
	//tool
	private Random generator = new Random();
	
	//moving track
	private int x;
	private int y;
	private int addX;
	private int addY;
	
	//restart button
	private JButton btn;
	
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
		
		//reStart button
		btn = new JButton("<html>You dead<br> restart?<html>");
		btn.setBounds(w/2-50,h/10-25,100,50);
		btn.addActionListener(new BtnListener());
		btn.setVisible(false);
		add(btn);
		
		//moving picture
		pic = new JLabel();
		pic.setIcon(monicaA);
		pic.addMouseListener(new MonicaLis());
		setSize();
		monica = new JPanel();
		monica.setBounds(x, y, w/10, h/10);
		monica.add(pic);
		add(monica);
		
		//base Maze
		basePanel = new BasePanel();
		basePanel.setBounds(0, 0, w-20, h-30);
		add(basePanel);
		setVisible(true);
		
		//moving picture's track
		x = 0;
		y = 0;
		addX = generator.nextInt(3) + 4;
		addY = generator.nextInt(3) + 4;
		monicaPool = Executors.newScheduledThreadPool(2);
		
		//moving thread
		monicaPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				//arrive the screen's far right
				if(x > w - 10 - w/10) {
					addX *= -1;
				}
				
				//arrive the screen's far left
				if(x < 0) {
					addX *= -1;
				}
				
				//arrive the screen's far bottom
				if(y > h-40-h/10) {
					addY *= -1;
				}
				
				//arrive the screen's far top
				if(y < 0) {
					addY *= -1;
				}

				x += addX;
				y += addY;
				monica.setLocation(x, y);	
			}	
		}, 0, 50, TimeUnit.MILLISECONDS);
		
		//change picture thread
		monicaPool.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				if(isChange()) {
					pic.setIcon(monicaB);
				}
				else {
					pic.setIcon(monicaA);
				}
			}
		}, 0, 1000, TimeUnit.MILLISECONDS);
	}
	
	private void setSize() {
		( (ImageIcon)monicaA ).setImage( ( (ImageIcon)monicaA ).getImage().getScaledInstance(w/10, h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)monicaB ).setImage( ( (ImageIcon)monicaB ).getImage().getScaledInstance(w/10, h/10,Image.SCALE_DEFAULT) );	
	}
	
	private boolean isChange() {
		if(generator.nextInt(3) == 2) {
			return true;
		}
		return false;
	}
	
	private class MonicaLis implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(((JLabel)( e.getComponent() )).getIcon() == monicaB) {
				monicaPool.shutdownNow();
				IrritatingMaze.pool.shutdownNow();
				IrritatingMaze.heartPool.shutdownNow();
				pic.setIcon(monicaC);
				( (ImageIcon)monicaC ).setImage( ( (ImageIcon)monicaC ).getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT) );
				monica.setBounds(0, 0, w, h);
				
				btn.setVisible(true);
				
			}
		
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}		
	}	
	
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Main.reStart();
		}
		
	}
}
