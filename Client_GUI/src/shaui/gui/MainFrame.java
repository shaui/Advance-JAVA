package shaui.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JLabel imgLabel;
	private JLabel hpLabel;
	private JLabel msgLabel;
	private JButton btnAttack;

	public MainFrame() {
		/*基本設置*/
		setTitle("Socket Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		
		/*把Frame置中*/
		setLocation((int)(ScreenSize.getX()*0.5)-350,(int)(ScreenSize.getY()*0.5)-350);	
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp3.setLayout(new GridLayout(2,1));
		imgLabel = new JLabel();
		hpLabel = new JLabel();
		msgLabel = new JLabel();
		btnAttack = new JButton("Attack");

		Icon img = new ImageIcon(getClass().getResource("BOSS.png"));
		imgLabel.setIcon(img);
		hpLabel.setText("HP:500");
		msgLabel.setText("msg:");
		//Panel用來置中
		jp1.add(imgLabel);
		jp2.add(hpLabel);
		jp3.add(msgLabel);
		jp3.add(btnAttack);
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public JLabel getHpLabel() {
		return hpLabel;
	}

	public void setHpLabel(JLabel hpLabel) {
		this.hpLabel = hpLabel;
	}

	public JLabel getMsgLabel() {
		return msgLabel;
	}

	public void setMsgLabel(JLabel msgLabel) {
		this.msgLabel = msgLabel;
	}

	public JButton getBtnAttack() {
		return btnAttack;
	}

	public void setBtnAttack(JButton btnAttack) {
		this.btnAttack = btnAttack;
	}
}
