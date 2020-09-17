package irritating_maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class IrritatingMaze extends JPanel{

	private static final int row_num = 10;
	private static final int coluimn_num = 10;
	
	private static Scanner s;
	private static int[][] record = new int[row_num][coluimn_num];
	private JLabel[] block = new JLabel[100];
	private Icon diamond = new ImageIcon(getClass().getResource("diamond.png"));
	private Icon brickWall = new ImageIcon(getClass().getResource("brickwall.png"));;
	private Icon heart = new ImageIcon(getClass().getResource("heart.png"));;
	private int heartCount[] = new int[10];
	private Random r = new Random();
	
	public IrritatingMaze() {
		setLayout(new GridLayout(10,10));
		readFile();
		for(int i=0; i<block.length; i++) {
			block[i] = new JLabel();
		}
		drawMaze();
		for(int i=0; i<block.length; i++) {
			add(block[i]);
		}
		setVisible(true);
	}
	
	private void readFile() {
		try {
			s = new Scanner(Paths.get("map.txt"));
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
		setHeart();
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
					count++;
				}
				else {
					block[count].setIcon(heart);
					count++;
				}
			}
		}
	}
	
	private void setHeart() {
		for(int i=0; i<record.length; i++) {
			record[i] = Arrays.stream(record[i])
			.map(x -> x = x*newEven() + x)
			.toArray();
		}
		record[3][0] = 2; //避免出口被設定成愛心
	}
	
	private int newEven() {
		int x = r.nextInt(4);
		if(x%2 != 0) {
			return 0;
		}
		else {
			return x;
		}
	}
	
	private void setSize() {
		( (ImageIcon)brickWall ).setImage( ( (ImageIcon)brickWall ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart ).setImage( ( (ImageIcon)heart ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)diamond ).setImage( ( (ImageIcon)diamond ).getImage().getScaledInstance(MazeFrame.w/10, MazeFrame.h/10,Image.SCALE_DEFAULT) );	
	}
	private void reSize() {
		( (ImageIcon)brickWall ).setImage( ( (ImageIcon)brickWall ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)heart ).setImage( ( (ImageIcon)heart ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
		( (ImageIcon)diamond ).setImage( ( (ImageIcon)diamond ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		reSize();
	}
	
	private class RoadListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			if(MazeFrame.bloodStripe.hpNum > 10) {
				MazeFrame.bloodStripe.hpNum = MazeFrame.bloodStripe.hpNum - 1 ;
				MazeFrame.bloodStripe.setHp();
				MazeFrame.bloodStripe.repaint();
			}
		}
	}
	
	private class WallListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			if(MazeFrame.bloodStripe.hpNum > 10) {
				MazeFrame.bloodStripe.hpNum = MazeFrame.bloodStripe.hpNum - 4 ;
				MazeFrame.bloodStripe.setHp();
			}
		}
	}
}
