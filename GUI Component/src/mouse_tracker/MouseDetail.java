package mouse_tracker;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JFrame;
import javax.swing.JLabel;

import component.module.MyFrame;


public class MouseDetail extends MyFrame{

	private JLabel text;
	public MouseDetail()
	{
		text = new JLabel("text");
		
		add(text, BorderLayout.SOUTH);
		
		/*�٬OaddMouseListener*/
		addMouseListener(new Adapter());
		
		
	}
	
	private class Adapter extends MouseAdapter
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.isMetaDown())
			{
				text.setText("right click" + e.getClickCount());
			}
			else if(e.isAltDown())
			{
				text.setText("middle click" + e.getClickCount());
			}
			else
			{
				text.setText("left click" + e.getClickCount());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �۰ʲ��ͪ���k Stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO �۰ʲ��ͪ���k Stub
			
		}
		
	}
}
