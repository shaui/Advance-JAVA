/*���2B_106403540_���ӭ�*/
package HW1_106403540_���ӭ�;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*ø�ϰ�*/
public class PaintPanel extends JPanel{
	
	private JLabel mouse_site;
	
	public PaintPanel()
	{
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		/*Frame�̤U��������*/
		mouse_site = new JLabel("���Ц�m : (0,0)");
		mouse_site.setForeground(Color.WHITE);
		mouse_site.setBackground(Color.BLACK);
		mouse_site.setOpaque(true);
		add(mouse_site, BorderLayout.SOUTH);
		
		/*�]�w��ť��*/
		addMouseMotionListener(new MouseMotionLis());
	}
	
	public class MouseMotionLis extends MouseMotionAdapter
	{
		@Override
		public void mouseMoved(MouseEvent e) {
			mouse_site.setText("���Ц�m : (" + e.getX() + "," + e.getY() + ")");
		}
	}
	
}
