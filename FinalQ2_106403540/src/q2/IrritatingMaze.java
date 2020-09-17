package q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class IrritatingMaze extends JPanel{
	//Maze size
	private static final int row_num = 10;
	private static final int coluimn_num = 10;
	
	//store the maze
	private static int[][] record = new int[row_num][coluimn_num];
	private JLabel[] block = new JLabel[100];
	
	//Picture
	private Icon diamond = new ImageIcon(getClass().getResource("diamond.png"));
	private Icon brickWall = new ImageIcon(getClass().getResource("brickwall.png"));
	private Icon grayBrickWall = new ImageIcon(getClass().getResource("grayBrickWall.png"));
	private Icon heart10 = new ImageIcon(getClass().getResource("heart10.png"));
	private Icon heart8 = new ImageIcon(getClass().getResource("heart8.png"));
	private Icon heart6 = new ImageIcon(getClass().getResource("heart6.png"));
	private Icon heart4 = new ImageIcon(getClass().getResource("heart4.png"));
	private Icon heart2 = new ImageIcon(getClass().getResource("heart2.png"));
	
	//tool
	private static Scanner s;
	private Random r = new Random();
	
	//Thread pool
	public static ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
	public static ScheduledExecutorService heartPool;
	public static ScheduledExecutorService wallPool;
	public static int heartPoint = 10;


	public IrritatingMaze() {
		
		setLayout(new GridLayout(10,10));
		readFile();
		
		//create 100 labels
		for(int i=0; i<block.length; i++) {
			block[i] = new JLabel();
		}
		
		//draw the labels
		drawMaze();
		
		//add labels to Panel
		for(int i=0; i<block.length; i++) {
			add(block[i]);
		}
		
		//change the heart
		setHeart();
		heartPool = Executors.newScheduledThreadPool(1);
		heartPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				updateMaze(heartPoint);
				heartPoint -= 2;
			}
		}, r.nextInt(1500), 2000, TimeUnit.MILLISECONDS);
		
		wallPool = Executors.newScheduledThreadPool(1);
		wallPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				updateWall(BloodStripe.hp);
			}
		}, 0, 100, TimeUnit.MILLISECONDS);
		
		setVisible(true);
	}
	
	private void readFile() {
		try {
			if(	Main.player.getLevel() == 1) {
				s = new Scanner(Paths.get("1.txt"));
			}
			else if(Main.player.getLevel() == 2) {
				System.out.println(666);
				s = new Scanner(Paths.get("2.txt"));
			}
			else {
				System.out.println(777);
				s = new Scanner(Paths.get("3.txt"));
			}
			
			while(s.hasNext()) {
				for(int i=0; i<record.length; i++) {
					record[i] = Arrays.stream(new int[record[i].length])
					.map(x -> x = s.nextInt())
					.toArray();
				}
			}
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	private void drawMaze() {
		setSize();

		int count = 0;
		for(int i=0; i<record.length; i++) { //draw the maze
			for(int j=0; j<record[i].length; j++) {
				if(record[i][j] == 0) { //non-obstacle
					block[count].setOpaque(true);
					block[count].setBackground(Color.WHITE);
					block[count].addMouseListener(new RoadListener());
					count++;
				}
				else if(record[i][j] == 1) { //obstacle
					block[count].setIcon(brickWall);
					block[count].addMouseListener(new WallListener());
					count++;
				}
				else if(record[i][j] == 2){ //Walking path
					block[count].setIcon(diamond);
					block[count].addMouseListener(new DiamondListener());
					count++;
				}
				else {
					block[count].setIcon(heart10);
					block[count].addMouseListener(new HeartListener(10));
					count++;
				}
			}
		}
	}
	
	private boolean change() {
		boolean status = false;
		if(r.nextInt(7) == 6) {
			status = true;
		}
		return status;
	}
	
	private void setHeart() {
		for(int i=0; i<record.length; i++) {
			record[i] = Arrays.stream(record[i])
			.map(x -> x == 1 && change() ? (x = 3) : (x = x + 0))
			.toArray();
		}
	}
	
	private void updateWall(int point) {
		setSize();
		point = BloodStripe.hp;
		int count = 0;
		for(int i=0; i<record.length; i++) { //draw the maze
			for(int j=0; j<record[i].length; j++) {
				if(record[i][j] == 1) { //obstacle
					if(point >= 30) {
						block[count].setIcon(brickWall);
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new WallListener());
						count++;
					}
					else {
						block[count].setIcon(grayBrickWall);
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new WallListener());
						count++;
					}
					
				}
				else {
					count++;
				}
			}
		}
	}
	
	//update the heart and wall 
	private void updateMaze(int point) {
		setSize();
		point = heartPoint;

		int count = 0;
		for(int i=0; i<record.length; i++) { //draw the maze
			for(int j=0; j<record[i].length; j++) {
				if(record[i][j] == 3){ //heart path
					if(point == 10) {
						block[count].setIcon(heart10);
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new HeartListener(10));
						count++;
					}
					else if(point == 8) {
						block[count].setIcon(heart8);
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new HeartListener(8));
						count++;
					}
					else if(point == 6) {
						block[count].setIcon(heart6);
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new HeartListener(6));
						count++;
					}
					else if(point == 4) {
						block[count].setIcon(heart4);
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new HeartListener(4));
						count++;
					}
					else if(point == 2) {
						block[count].setIcon(heart2);
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new HeartListener(2));
						count++;
					}
					else {
						block[count].setIcon(brickWall);
						record[i][j] = 1;
						block[count].removeMouseListener(block[count].getMouseListeners()[0]);
						block[count].addMouseListener(new WallListener());
						count++;
						
					}	
				}
				else {
					count++;
				}
			}
		}
		if(heartPoint == 0) {
			heartPool.shutdownNow();
			heartPoint = 10;
		}
	}
	
	private void changeHeart() {
		setHeart();
//		updateMaze();	
		readFile();
	}
	
	private void setSize() {
		( (ImageIcon)brickWall ).setImage( ( (ImageIcon)brickWall ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)grayBrickWall ).setImage( ( (ImageIcon)grayBrickWall ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart10 ).setImage( ( (ImageIcon)heart10 ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart8 ).setImage( ( (ImageIcon)heart8 ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart6 ).setImage( ( (ImageIcon)heart6 ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart4 ).setImage( ( (ImageIcon)heart4 ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart2 ).setImage( ( (ImageIcon)heart2 ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)diamond ).setImage( ( (ImageIcon)diamond ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );		
	}
	private void reSize() {
		( (ImageIcon)brickWall ).setImage( ( (ImageIcon)brickWall ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)grayBrickWall ).setImage( ( (ImageIcon)grayBrickWall ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart10 ).setImage( ( (ImageIcon)heart10 ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart8 ).setImage( ( (ImageIcon)heart8 ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart6 ).setImage( ( (ImageIcon)heart6 ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart4 ).setImage( ( (ImageIcon)heart4 ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart2 ).setImage( ( (ImageIcon)heart2 ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)diamond ).setImage( ( (ImageIcon)diamond ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		reSize();
	}
	
	private void setRoadHp() {
		if(BloodStripe.hp > 0) {
			BloodStripe.hp -= 2 ;
			BloodStripe.setHp();
		}
	}
	
	private void setWallHp() {
		if(BloodStripe.hp > 0) {
			BloodStripe.hp -= 20;
			BloodStripe.setHp();
		}
	}
	
	private class RoadListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			pool = Executors.newScheduledThreadPool(1);
//			temp = (JLabel) e.getComponent();
			pool.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
//					if(temp == e.getComponent()) {
						setRoadHp();
//					}
				}
			}, 1000, 1000, TimeUnit.MILLISECONDS);
			
			setRoadHp();
		}
		public void mouseExited(MouseEvent e) {
			pool.shutdownNow();
		}
	}
	
	private class WallListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			pool = Executors.newScheduledThreadPool(1);
//			temp = (JLabel) e.getComponent();
			pool.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
//					if(temp == e.getComponent()) {
						setWallHp();
//					}
				}
			}, 1000, 1000, TimeUnit.MILLISECONDS);
			setWallHp();
		}
		public void mouseExited(MouseEvent e) {
			pool.shutdownNow();
		}
	}
	
	private class HeartListener extends MouseAdapter {
		
		public int point;
		public HeartListener(int p) {
			point = p;
		}
		
		public void mouseEntered(MouseEvent e) {
			if(BloodStripe.hp > 0) {
				BloodStripe.hp += point;
				BloodStripe.setHp();
				JLabel eatLabel = (JLabel) e.getComponent();
				eatLabel.setVisible(false);
//				eatLabel.setIcon(brickWall);
//				eatLabel.removeMouseListener(eatLabel.getMouseListeners()[0]);
//				eatLabel.addMouseListener(new WallListener());
//				eatLabel.getMouseListeners()[0].mouseEntered(e);
			}
		}
	}
	
	private class DiamondListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			String ID = Main.player.getID();
			int level = Main.player.getLevel();
			//還沒到最後一關
			if(level < 3) {
				level += 1;
				Main.player.setLevel(level);
				Main.dbms.updateData(ID, level);
				JOptionPane.showMessageDialog(null, "You Win!");
				Main.reStart();
			}
			else {
				JOptionPane.showMessageDialog(null, "You finish the game");
				System.exit(1);
			}
			
			
		}
	}
}
