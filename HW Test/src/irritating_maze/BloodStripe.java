package irritating_maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BloodStripe extends JPanel{
	private static JProgressBar jpb;
	//JProgressBar的長寬
	private int w = 734;
	private int h = 20;
	public static int hp = 100;
	
	public BloodStripe() {
		jpb = new JProgressBar();
		jpb.setForeground(Color.BLUE);
		jpb.setMinimum(0);
//		jpb.setMaximum(200);
		//設定顯示目前剩餘%
		jpb.setStringPainted(true);
		
		jpb.setValue(hp);
		//設定JProgressBar的長寬
		jpb.setPreferredSize(new Dimension(w,h));
		add(jpb);
	}
	
	public static void setHp() {	
		if(hp >= 0) {
			if(hp >= 100) {
				hp = 100;
			}
			jpb.setValue(hp);
		}
		else {
			hp = 0;
			jpb.setValue(hp);
		}
		
		if(hp <= 0) {
			JOptionPane.showMessageDialog(null, "You are died");
			//reStart the game
			Main.reStart();
		}
	}
	
	private void reSize() {
		w = getWidth();
		jpb.setPreferredSize(new Dimension(w,h));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		reSize();
	}
}
