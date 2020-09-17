package irritating_maze;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BloodStripe extends JPanel{
	public static int hpNum = 20;
	private static JPanel[] hp = new JPanel[30];
	
	public BloodStripe() {
		setLayout(new GridLayout(3,10));
		for(int i=0; i<hp.length; i++) {
			hp[i] = new JPanel();
		}
		setHp();
		for(int i=0; i<hp.length; i++) {
			add(hp[i]);
		}
	}
	
	public static void setHp() {
		if(hpNum < 10) {
			hpNum = 10;
		}
		for(int i=10; i<hpNum; i++) {
			hp[i].setBackground(Color.BLUE);
		}
		for(int i=19; i>hpNum-1; i--) {
			hp[i].setBackground(Color.WHITE);
		}
		if(hpNum == 10) {
			JOptionPane.showMessageDialog(null, "You are died");
		}
		
	}
}
