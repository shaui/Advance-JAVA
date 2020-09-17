package boxLayout;

import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.Box;

import component.module.MyFrame;

public class BoxFrame extends MyFrame{
	
	JButton[] hbtn = new JButton[3];
	JButton[] vbtn = new JButton[3];
	
	public BoxFrame() {
		setLayout(new BorderLayout());
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createVerticalBox();
		for(int i=0; i<3; i++) {
			hbtn[i] = new JButton(""+(i+1));
			vbtn[i] = new JButton(""+(i+1));
			b1.add(hbtn[i]);
			b2.add(vbtn[i]);
		}
		add(b1);
		add(b2);
		setVisible(true);
	}
}
