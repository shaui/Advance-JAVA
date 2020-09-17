/*資管2B_106403540_陳志剛*/
package HW1_106403540_陳志剛;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*繪圖區*/
public class PaintPanel extends JPanel{
	
	private JLabel mouse_site;
	
	public PaintPanel()
	{
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		/*Frame最下面的註解*/
		mouse_site = new JLabel("指標位置 : (0,0)");
		mouse_site.setForeground(Color.WHITE);
		mouse_site.setBackground(Color.BLACK);
		mouse_site.setOpaque(true);
		add(mouse_site, BorderLayout.SOUTH);
		
		/*設定監聽器*/
		addMouseMotionListener(new MouseMotionLis());
	}
	
	public class MouseMotionLis extends MouseMotionAdapter
	{
		@Override
		public void mouseMoved(MouseEvent e) {
			mouse_site.setText("指標位置 : (" + e.getX() + "," + e.getY() + ")");
		}
	}
	
}
