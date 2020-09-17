/*���2B_106403540_���ӭ�*/
package gui_Lab_Painter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*������s*/
public class Btn_Panel extends JPanel{

	private JButton foreground;
	private JButton background;
	private JButton clear;
	private String[] btn_name = {"�e����","�I����","�M���e��"};
	
	public Btn_Panel()
	{

		/*3�ӫ��s*/
		foreground = new JButton(btn_name[0]);
		background = new JButton(btn_name[1]);
		clear = new JButton(btn_name[2]);
		
		BtnActionLis BtnLis = new BtnActionLis();
		
		/*�[�J��ť��*/
		foreground.addActionListener(BtnLis);
		background.addActionListener(BtnLis);
		clear.addActionListener(BtnLis);
		
		/*�[�J��Panel*/
		add(foreground);
		add(background);
		add(clear);
	}
	
	private class BtnActionLis implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("�I�� " + e.getActionCommand());	
		}
		
	}
}
