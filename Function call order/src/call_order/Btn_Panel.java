/*���2B_106403540_���ӭ�*/
package call_order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*������s*/
public class Btn_Panel extends JPanel{

	private JButton foreground;
	private JButton background;
	public static JButton clear;
	private JButton eraser;
	private String[] btn_name = {"�e����","�I����","�M���e��","�����"};
	public static String state = "";
	
	public Btn_Panel()
	{

		/*3�ӫ��s*/
		foreground = new JButton(btn_name[0]);
		background = new JButton(btn_name[1]);
		clear = new JButton(btn_name[2]);
		eraser = new JButton(btn_name[3]);
		
		BtnActionLis BtnLis = new BtnActionLis();
		
		/*�[�J��ť��*/
		foreground.addActionListener(BtnLis);
		background.addActionListener(BtnLis);
		clear.addActionListener(BtnLis);
		eraser.addActionListener(BtnLis);
		
		/*�[�J��Panel*/
		add(foreground);
		add(background);
		add(clear);
		add(eraser);
	}
	
	private class BtnActionLis implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("�I�� " + e.getActionCommand());
			String last_state = state; //check last time whether is eraser
			
			state = e.getActionCommand();
			
			if(state == "�M���e��") {
				System.err.println(state);
				Painter_Frame.paint_pane.repaint(); //clear the pane
			}
			
			if(last_state == "�����") {
				System.err.println(123);
				state = ""; //close the eraser effect
			}
			
			
			
			
			
		}
		
	}
}
