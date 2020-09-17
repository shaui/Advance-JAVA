/*���2B_106403540_���ӭ�*/
package call_order;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;



/*ø�ϰ�*/
public class PaintPanel2 extends JPanel{
	
	private JLabel mouse_site;
	
	private ArrayList<String> locate_state = new ArrayList<>();
	
	
	//Brush's Data
	private ArrayList<Point> points = new ArrayList<>(); 
	private ArrayList<Integer> brush_size_x = new ArrayList<>();
	private ArrayList<Integer> brush_size_y = new ArrayList<>();
	private ArrayList<Color> brush_color = new ArrayList<>();
	
	
	
	//Straight Line Data
	private ArrayList<Point> line_init_points = new ArrayList<>(); 
	private ArrayList<Point> line_end_points = new ArrayList<>();
	private ArrayList<Integer> line_size = new ArrayList<>();
	private ArrayList<Boolean> line_state = new ArrayList<>();	
	private ArrayList<Color> line_color = new ArrayList<>();
	
	
	//Oval Data
	private ArrayList<Point> oval_init_points = new ArrayList<>(); 
	private ArrayList<Point> oval_end_points = new ArrayList<>();
	private ArrayList<Integer> oval_size = new ArrayList<>();
	private ArrayList<Boolean> oval_state = new ArrayList<>();
	private ArrayList<Color> oval_color = new ArrayList<>();
	
	
	//Rect Data
	private ArrayList<Point> rect_init_points = new ArrayList<>(); 
	private ArrayList<Point> rect_end_points = new ArrayList<>();
	private ArrayList<Integer> rect_size = new ArrayList<>();
	private ArrayList<Boolean> rect_state = new ArrayList<>();
	private ArrayList<Color> rect_color = new ArrayList<>();
	
	
	//RoundRect Data
	private ArrayList<Point> roundRect_init_points = new ArrayList<>(); 
	private ArrayList<Point> roundRect_end_points = new ArrayList<>();
	private ArrayList<Integer> roundRect_size = new ArrayList<>();
	private ArrayList<Boolean> roundRect_state = new ArrayList<>();
	private ArrayList<Color> roundRect_color = new ArrayList<>();
	
	
	public static int sizeX = 6;
	public static int sizeY = 6;
	private int init_x;
	private int init_y;
	private int end_x;
	private int end_y;
	private Color drag_color;
	
	public PaintPanel2()
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
		addMouseListener(new MouseLis());
		
		
	}
	
	public static void setSizeX(int size) {
		sizeX = size;
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
			if(Btn_Panel.state == "�����") {
				drag_color = Color.WHITE;
			}
			else {
				drag_color = Color.BLACK;
			}
			switch (Paint_Tool_Panel.tool) {
				case "����":
					break;
					
				case "���u":
					line_init_points.add(e.getPoint());
					init_x = e.getX(); //���o�C���̷s�I���ɪ�x�I
					init_y = e.getY(); //���o�C���̷s�I���ɪ�Y�I
					line_size.add(Brush_Size_Panel.sizeX); //���o��e���u�ʲ�
					line_state.add(Filler_Panel.state); //get the state(fill or unfill) now
					break;
					
				case "����":
					oval_init_points.add(e.getPoint());
					init_x = e.getX(); //���o�C���̷s�I���ɪ�x�I
					init_y = e.getY(); //���o�C���̷s�I���ɪ�Y�I
					oval_size.add(Brush_Size_Panel.sizeX); //���o��e���u�ʲ�
					oval_state.add(Filler_Panel.state);
					break;
					
				case "�x��":
					rect_init_points.add(e.getPoint());
					init_x = e.getX(); //���o�C���̷s�I���ɪ�x�I
					init_y = e.getY(); //���o�C���̷s�I���ɪ�Y�I
					rect_size.add(Brush_Size_Panel.sizeX); //���o��e���u�ʲ�	
					rect_state.add(Filler_Panel.state);
					break;
					
				case "�ꨤ�x��":
					roundRect_init_points.add(e.getPoint());
					init_x = e.getX(); //���o�C���̷s�I���ɪ�x�I
					init_y = e.getY(); //���o�C���̷s�I���ɪ�Y�I
					roundRect_size.add(Brush_Size_Panel.sizeX); //���o��e���u�ʲ�
					roundRect_state.add(Filler_Panel.state);
					break;
			}	
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			/*if(Paint_Tool_Panel.tool == "���u") {
				line_end_points.add(e.getPoint());
				
			}*/
			switch (Paint_Tool_Panel.tool) {
			case "����":
				break;
			case "���u":
				line_end_points.add(e.getPoint());
				if(Btn_Panel.state == "�����") {
					line_color.add(Color.WHITE);
				}
				else {
					line_color.add(Color.BLACK);
				}
				locate_state.add("���u");
				break;
			case "����":
				oval_end_points.add(e.getPoint());
				if(Btn_Panel.state == "�����") {
					oval_color.add(Color.WHITE);
				}
				else {
					oval_color.add(Color.BLACK);
				}
				locate_state.add("����");
				break;
			case "�x��":
				rect_end_points.add(e.getPoint());
				if(Btn_Panel.state == "�����") {
					rect_color.add(Color.WHITE);
				}
				else {
					rect_color.add(Color.BLACK);
				}
				locate_state.add("�x��");
				break;
			case "�ꨤ�x��":
				roundRect_end_points.add(e.getPoint());
				if(Btn_Panel.state == "�����") {
					roundRect_color.add(Color.WHITE);
				}
				else {
					roundRect_color.add(Color.BLACK);
				}
				locate_state.add("�ꨤ�x��");
				break;
			}
		}
	}
	
	private class MouseMotionLis extends MouseMotionAdapter
	{
		@Override
		public void mouseMoved(MouseEvent e){
			mouse_site.setText("���Ц�m : (" + e.getX() + "," + e.getY() + ")");
		}
		
		public void mouseDragged(MouseEvent e){
			switch (Paint_Tool_Panel.tool) {
				case "����":
					points.add(e.getPoint());
					brush_size_x.add(Brush_Size_Panel.sizeX);
					brush_size_y.add(Brush_Size_Panel.sizeY);
					if(Btn_Panel.state == "�����") {
						brush_color.add(Color.WHITE); //eraser effect
					}
					else {
						brush_color.add(Color.BLACK); //default color
					}
					locate_state.add("����");
					break;
				case "���u":
					end_x = e.getPoint().x; //�ʺA���odrag�ɳ̫᪺�Ix
					end_y = e.getPoint().y; //�ʺA���odrag�ɳ̫᪺�Iy
					break;
				case "����":
					end_x = e.getPoint().x; //�ʺA���odrag�ɳ̫᪺�Ix
					end_y = e.getPoint().y; //�ʺA���odrag�ɳ̫᪺�Iy
					break;
				case "�x��":
					end_x = e.getPoint().x; //�ʺA���odrag�ɳ̫᪺�Ix
					end_y = e.getPoint().y; //�ʺA���odrag�ɳ̫᪺�Iy
					
					break;
				case "�ꨤ�x��":
					end_x = e.getPoint().x; //�ʺA���odrag�ɳ̫᪺�Ix
					end_y = e.getPoint().y; //�ʺA���odrag�ɳ̫᪺�Iy
					break;
			}
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.err.println("abc");
		if(Btn_Panel.state == "�M���e��") {
			//clear the brush data
			points.clear();
			brush_size_x.clear();
			brush_size_y.clear();
			brush_color.clear();
			
			//clear the line data
			line_init_points.clear();
			line_end_points.clear();
			line_size.clear();
			line_state.clear();
			line_color.clear();
			
			//clear the oval data
			oval_init_points.clear();
			oval_end_points.clear();
			oval_size.clear();
			oval_state.clear();
			oval_color.clear();
			
			//clear the rect data
			rect_init_points.clear();
			rect_end_points.clear();
			rect_size.clear();
			rect_state.clear();
			rect_color.clear();
			
			//clear the roundRect data
			roundRect_init_points.clear();
			roundRect_end_points.clear();
			roundRect_size.clear();
			roundRect_state.clear();
			roundRect_color.clear();
			
			//clear the counter
			locate_state.clear();
			
			super.paintComponent(g);
			System.out.println("abc");
			Btn_Panel.state = "";
			
		}
		else {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;  
			BasicStroke dash;
			
			paintAll(g, g2);
			

			//draw the current picture
			switch (Paint_Tool_Panel.tool) {
				case "���u":
					g.setColor(drag_color); //set the new line color
					if(Filler_Panel.state) {
						g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX)); //set the current size
						g.drawLine(init_x, init_y, end_x, end_y);
					}
					else {
						dash = new BasicStroke(Brush_Size_Panel.sizeX, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f); //set the current dash
						g2.setStroke(dash);
						g.drawLine(init_x, init_y, end_x, end_y);
					}
					break;
				case "����":
					g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX)); //set the current size
					g.setColor(drag_color);//set the new oval color 
					if(Filler_Panel.state) {
						g.fillOval( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					else {
						g.drawOval( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					break;
				case "�x��":
					g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX)); //set the current size
					g.setColor(drag_color);//set the new color
					if(Filler_Panel.state) {
						g.fillRect( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					else {
						g.drawRect( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					break;
				case "�ꨤ�x��":
					g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX)); //set the current size
					g.setColor(drag_color);//set the new color
					if(Filler_Panel.state) {
						g.fillRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
					}
					else {
						g.drawRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
					}
					break;
			}
		}
	}
	public void paintAll(Graphics g, Graphics2D g2) {
		BasicStroke dash;
		//point iterator
		Iterator<String> counter = locate_state.iterator();
		Iterator<Point> it_points = points.iterator();
		Iterator<Integer> it_brush_size_x = brush_size_x.iterator();
		Iterator<Integer> it_brush_size_y = brush_size_y.iterator();
		Iterator<Color> it_brush_color = brush_color.iterator();
		//line iterator
		Iterator<Point> it_line_init_points = line_init_points.iterator();
		Iterator<Point> it_line_end_points = line_end_points.iterator();
		Iterator<Integer> it_line_size = line_size.iterator();
		Iterator<Boolean> it_line_state = line_state.iterator();
		Iterator<Color> it_line_color = line_color.iterator();
		//oval iterator
		Iterator<Point> it_oval_init_points = oval_init_points.iterator();
		Iterator<Point> it_oval_end_points = oval_end_points.iterator();
		Iterator<Integer> it_oval_size = oval_size.iterator();
		Iterator<Boolean> it_oval_state = oval_state.iterator();
		Iterator<Color> it_oval_color = oval_color.iterator();
		//rect iterator
		Iterator<Point> it_rect_init_points = rect_init_points.iterator();
		Iterator<Point> it_rect_end_points = rect_end_points.iterator();
		Iterator<Integer> it_rect_size = rect_size.iterator();
		Iterator<Boolean> it_rect_state = rect_state.iterator();
		Iterator<Color> it_rect_color = rect_color.iterator();
		//roundRect iterator
		Iterator<Point> it_roundRect_init_points = roundRect_init_points.iterator();
		Iterator<Point> it_roundRect_end_points = roundRect_end_points.iterator();
		Iterator<Integer> it_roundRect_size = roundRect_size.iterator();
		Iterator<Boolean> it_roundRect_state = roundRect_state.iterator();
		Iterator<Color> it_roundRect_color = roundRect_color.iterator();
		
		
		while(counter.hasNext()) {
			switch ( counter.next() ) {
				case "����":
						g.setColor( it_brush_color.next() );
						Point brush_p = it_points.next();
						g.fillOval( brush_p.x,  brush_p.y, it_brush_size_x.next(), it_brush_size_y.next() );
						break;
				case "���u":
					g.setColor( it_line_color.next()); //set the each time color
					if(it_line_state.next()) {
						g2.setStroke(new BasicStroke(it_line_size.next()));
						Point line_init_p = it_line_init_points.next();
						Point line_end_p = it_line_end_points.next();
						g.drawLine(line_init_p.x, line_init_p.y, line_end_p.x, line_end_p.y);	
					}
					else {
						dash = new BasicStroke(it_line_size.next(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f);
						g2.setStroke(dash);
						Point line_init_p = it_line_init_points.next();
						Point line_end_p = it_line_end_points.next();
						g.drawLine(line_init_p.x, line_init_p.y, line_end_p.x, line_end_p.y);
					}
					break;
				case "����":
					g.setColor(it_oval_color.next());//set the each time color
					if(it_oval_state.next()) {
						g2.setStroke( new BasicStroke( it_oval_size.next() ) );
						Point oval_init_p = it_oval_init_points.next();
						Point oval_end_p = it_oval_end_points.next();
						g.fillOval(oval_init_p.x, oval_init_p.y, oval_end_p.x-oval_init_p.x, oval_end_p.y-oval_init_p.y);
					}
					else {
						g2.setStroke( new BasicStroke( it_oval_size.next() ) );
						Point oval_init_p = it_oval_init_points.next();
						Point oval_end_p = it_oval_end_points.next();
						g.drawOval(oval_init_p.x, oval_init_p.y, oval_end_p.x-oval_init_p.x, oval_end_p.y-oval_init_p.y);
					}
					break;
				case "�x��":
					g.setColor(it_rect_color.next()); //get the each time color
					if(it_rect_state.next()) {
						g2.setStroke(new BasicStroke(it_rect_size.next()));
						Point rect_init_p = it_rect_init_points.next();
						Point rect_end_p = it_rect_end_points.next();
						g.fillRect(rect_init_p.x, rect_init_p.y, rect_end_p.x-rect_init_p.x, rect_end_p.y-rect_init_p.y);
					}
					else {
						g2.setStroke(new BasicStroke(it_rect_size.next()));
						Point rect_init_p = it_rect_init_points.next();
						Point rect_end_p = it_rect_end_points.next();
						g.drawRect(rect_init_p.x, rect_init_p.y, rect_end_p.x-rect_init_p.x, rect_end_p.y-rect_init_p.y);
					}
					break;
				case "�ꨤ�x��":
					g.setColor(it_roundRect_color.next());//set the each time color
					if(it_roundRect_state.next()) {
						g2.setStroke(new BasicStroke(it_roundRect_size.next()));
						Point roundRect_init_p = it_roundRect_init_points.next();
						Point roundRect_end_p = it_roundRect_end_points.next();
						g.fillRoundRect(roundRect_init_p.x, roundRect_init_p.y, roundRect_end_p.x-roundRect_init_p.x, roundRect_end_p.y-roundRect_init_p.y, 20 ,20);
					}
					else {
						g2.setStroke(new BasicStroke(it_roundRect_size.next()));
						Point roundRect_init_p = it_roundRect_init_points.next();
						Point roundRect_end_p = it_roundRect_end_points.next();
						g.drawRoundRect(roundRect_init_p.x, roundRect_init_p.y, roundRect_end_p.x-roundRect_init_p.x, roundRect_end_p.y-roundRect_init_p.y, 20 ,20);
					}
					break;
			}
		}
	
		
	}
}
