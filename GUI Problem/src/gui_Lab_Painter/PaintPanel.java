/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*繪圖區*/
public class PaintPanel extends JPanel{
	
	private JLabel mouse_site;
	private ArrayList<Point> points = new ArrayList<>();
	
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
	
	private class MouseMotionLis extends MouseMotionAdapter
	{
		@Override
		public void mouseMoved(MouseEvent e){
			mouse_site.setText("指標位置 : (" + e.getX() + "," + e.getY() + ")");
		}
		
		public void mouseDragged(MouseEvent e){
			points.add(e.getPoint());
			repaint();
			
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Point p : points) {
		g.fillOval( p.x, p.y, 4, 4);
		}
	}
	
}
