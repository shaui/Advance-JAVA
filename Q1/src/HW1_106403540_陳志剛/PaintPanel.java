/*資管2B_106403540_陳志剛*/
package HW1_106403540_陳志剛;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/*繪圖區*/
public class PaintPanel extends JPanel{
	
	private JLabel mouse_site;
	//the current "initial" and "end" x,y
	private int init_x;
	private int init_y;
	private int end_x;
	private int end_y;

	//the temp x,y to judge the coordinate change
	private int temp_x;
	private int temp_y;
	
	//RoundRect Data
	private ArrayList<Integer> roundRect_data = new ArrayList<>();
	
	public static int paint_wid;
	public static int paint_height;
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
		addMouseListener(new MouseLis());
		
		
		
	}
	
	private class MouseLis implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {

		}
		@Override
		public void mouseEntered(MouseEvent e) {

		}
		@Override
		public void mouseExited(MouseEvent e) {

		}
		@Override
		public void mousePressed(MouseEvent e) {
			init_x = e.getX(); 
			init_y = e.getY(); 
			temp_x = e.getX(); //get the temporary x point
			temp_y = e.getY(); //get the temporary y point
		}
		
		public void mouseReleased(MouseEvent e) {
			roundRect_data.add(init_x);
			roundRect_data.add(init_y);
			roundRect_data.add(end_x);
			roundRect_data.add(end_y);
		}
	}
	
	public class MouseMotionLis extends MouseMotionAdapter
	{
		@Override
		public void mouseMoved(MouseEvent e) {
			mouse_site.setText("指標位置 : (" + e.getX() + "," + e.getY() + ")");
		}
		
		public void mouseDragged(MouseEvent e){
			if(e.getPoint().x <= temp_x) {
				init_x = e.getPoint().x;
				end_x = temp_x;
			}
			else {
				init_x = temp_x;
				end_x = e.getPoint().x;
			}
			if(e.getPoint().y <= temp_y) {
				init_y = e.getPoint().y;
				end_y = temp_y;
			}
			else {
				init_y = temp_y;
				end_y = e.getPoint().y;
			}
			repaint();
		}
	}
	
	public void removeEnd() {
		for(int i=0; i<4; i++) {
			roundRect_data.remove(roundRect_data.size()-1);
		}
	}
	
	public void paintComponent(Graphics g) {
		paint_wid = getWidth();
		paint_height = getHeight();
		if(Tool_Panel.state == "刪除最新圖形") {
			super.paintComponent(g);
			if(roundRect_data.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error, not have any element.");
				Tool_Panel.state = "";
				super.paintComponent(g);
			}
			else {
				removeEnd();
				paintAll(g);
			}
		}
		else if(Tool_Panel.state == "draw") {
			super.paintComponent(g);
			paintAll(g);
			g.drawRoundRect(Tool_Panel.px, Tool_Panel.py, Tool_Panel.length, Tool_Panel.width, Tool_Panel.r_len, Tool_Panel.r_wid);
			roundRect_data.add(Tool_Panel.px);
			roundRect_data.add(Tool_Panel.py);
			roundRect_data.add(Tool_Panel.px + Tool_Panel.length);
			roundRect_data.add(Tool_Panel.px + Tool_Panel.width);
		}
		else {
			super.paintComponent(g);
			paintAll(g);
			g.drawRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
		}	
	}
	
	public void paintAll(Graphics g) {
		//roundRect iterator
		Iterator<Integer> it_roundRect_data = roundRect_data.iterator();
		
		while(it_roundRect_data.hasNext()) {
			int roundRect_init_x = it_roundRect_data.next();
			int roundRect_init_y = it_roundRect_data.next();
			int roundRect_end_x = it_roundRect_data.next();
			int roundRect_end_y = it_roundRect_data.next();
			g.drawRoundRect(roundRect_init_x, roundRect_init_y, roundRect_end_x-roundRect_init_x, roundRect_end_y-roundRect_init_y, 20 ,20);
		}
	}


	
	
}
