/*資管2B_106403540_陳志剛*/
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

import javax.swing.JLabel;
import javax.swing.JPanel;



/*繪圖區*/
public class PaintPanel extends JPanel{
	
	private JLabel mouse_site;
	
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
			if(Btn_Panel.state == "橡皮擦") {
				drag_color = Color.WHITE;
			}
			else {
				drag_color = Color.BLACK;
			}
			switch (Paint_Tool_Panel.tool) {
			case "筆刷":
				break;
				
			case "直線":
				line_init_points.add(e.getPoint());
				init_x = e.getX(); //取得每次最新點擊時的x點
				init_y = e.getY(); //取得每次最新點擊時的Y點
				line_size.add(Brush_Size_Panel.sizeX); //取得當前直線粗細
				line_state.add(Filler_Panel.state); //get the state(fill or unfill) now
				break;
				
			case "橢圓形":
				oval_init_points.add(e.getPoint());
				init_x = e.getX(); //取得每次最新點擊時的x點
				init_y = e.getY(); //取得每次最新點擊時的Y點
				oval_size.add(Brush_Size_Panel.sizeX); //取得當前直線粗細
				oval_state.add(Filler_Panel.state);
				break;
				
			case "矩形":
				rect_init_points.add(e.getPoint());
				init_x = e.getX(); //取得每次最新點擊時的x點
				init_y = e.getY(); //取得每次最新點擊時的Y點
				rect_size.add(Brush_Size_Panel.sizeX); //取得當前直線粗細	
				rect_state.add(Filler_Panel.state);
				break;
				
			case "圓角矩形":
				roundRect_init_points.add(e.getPoint());
				init_x = e.getX(); //取得每次最新點擊時的x點
				init_y = e.getY(); //取得每次最新點擊時的Y點
				roundRect_size.add(Brush_Size_Panel.sizeX); //取得當前直線粗細
				roundRect_state.add(Filler_Panel.state);
				break;
			}	
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			/*if(Paint_Tool_Panel.tool == "直線") {
				line_end_points.add(e.getPoint());
				
			}*/
			switch (Paint_Tool_Panel.tool) {
			case "筆刷":
				break;
			case "直線":
				line_end_points.add(e.getPoint());
				if(Btn_Panel.state == "橡皮擦") {
					line_color.add(Color.WHITE);
				}
				else {
					line_color.add(Color.BLACK);
				}
				break;
			case "橢圓形":
				oval_end_points.add(e.getPoint());
				if(Btn_Panel.state == "橡皮擦") {
					oval_color.add(Color.WHITE);
				}
				else {
					oval_color.add(Color.BLACK);
				}
				break;
			case "矩形":
				rect_end_points.add(e.getPoint());
				if(Btn_Panel.state == "橡皮擦") {
					rect_color.add(Color.WHITE);
				}
				else {
					rect_color.add(Color.BLACK);
				}
				break;
			case "圓角矩形":
				roundRect_end_points.add(e.getPoint());
				if(Btn_Panel.state == "橡皮擦") {
					roundRect_color.add(Color.WHITE);
				}
				else {
					roundRect_color.add(Color.BLACK);
				}
				break;
			}
		}
	}
	
	private class MouseMotionLis extends MouseMotionAdapter
	{
		@Override
		public void mouseMoved(MouseEvent e){
			mouse_site.setText("指標位置 : (" + e.getX() + "," + e.getY() + ")");
		}
		
		public void mouseDragged(MouseEvent e){
			switch (Paint_Tool_Panel.tool) {
				case "筆刷":
					points.add(e.getPoint());
					brush_size_x.add(Brush_Size_Panel.sizeX);
					brush_size_y.add(Brush_Size_Panel.sizeY);
					if(Btn_Panel.state == "橡皮擦") {
						brush_color.add(Color.WHITE); //eraser effect
					}
					else {
						brush_color.add(Color.BLACK); //default color
					}
					
					break;
				case "直線":
					end_x = e.getPoint().x; //動態取得drag時最後的點x
					end_y = e.getPoint().y; //動態取得drag時最後的點y
					break;
				case "橢圓形":
					end_x = e.getPoint().x; //動態取得drag時最後的點x
					end_y = e.getPoint().y; //動態取得drag時最後的點y
					break;
				case "矩形":
					end_x = e.getPoint().x; //動態取得drag時最後的點x
					end_y = e.getPoint().y; //動態取得drag時最後的點y
					
					break;
				case "圓角矩形":
					end_x = e.getPoint().x; //動態取得drag時最後的點x
					end_y = e.getPoint().y; //動態取得drag時最後的點y
					break;
			}
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(Btn_Panel.state == "清除畫面") {
			//clear the brush data
			points.clear();
			brush_size_x.clear();
			brush_size_y.clear();
			
			//clear the line data
			line_init_points.clear();
			line_end_points.clear();
			line_size.clear();
			line_state.clear();
			
			//clear the oval data
			oval_init_points.clear();
			oval_end_points.clear();
			oval_size.clear();
			oval_state.clear();
			
			//clear the rect data
			rect_init_points.clear();
			rect_end_points.clear();
			rect_size.clear();
			rect_state.clear();
			
			//clear the roundRect data
			roundRect_init_points.clear();
			roundRect_end_points.clear();
			roundRect_size.clear();
			roundRect_state.clear();
			
			super.paintComponent(g);
			System.out.println("abc");
			Btn_Panel.state = "";
		}
		else {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			BasicStroke dash;
			g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX));
			
			switch (Paint_Tool_Panel.tool) {
				case "筆刷":
					//draw the points
					for(int i=0; i<points.size(); i++) {
							g.setColor(brush_color.get(i));
							g.fillOval( points.get(i).x,  points.get(i).y, brush_size_x.get(i), brush_size_y.get(i));
					}
					
					//draw the Line
					if(line_end_points != null) {
						for(int i=0; i<line_end_points.size(); i++) {
							g.setColor(line_color.get(i)); //set the each time color
							if(line_state.get(i)) {
								g2.setStroke(new BasicStroke(line_size.get(i)));
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);	
							}
							else {
								dash = new BasicStroke(line_size.get(i), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f);
								g2.setStroke(dash);
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);
							}
						}	
					}
					
					//draw the oval
					if(oval_end_points != null) {
						for(int i=0; i<oval_end_points.size(); i++) {
							g.setColor(oval_color.get(i));//set the each time color
							if(oval_state.get(i)) {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.fillOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.drawOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
						}	
					}
					
					//draw the rect
					if(rect_end_points != null) {
						for(int i=0; i<rect_end_points.size(); i++) {
							g.setColor(rect_color.get(i)); //get the each time color
							if(rect_state.get(i)) {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.fillRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.drawRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							
						}	
					}
					
					//draw the roundRect
					if(roundRect_end_points != null) {
						for(int i=0; i<roundRect_end_points.size(); i++) {
							g.setColor(roundRect_color.get(i));//set the each time color
							if(roundRect_state.get(i)) {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.fillRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
							}
							else {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.drawRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
								}
						}	
					}
					break;
					
				case "直線":
					dash = new BasicStroke(Brush_Size_Panel.sizeX, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f);

					//draw the old Line
					if(line_end_points != null) {
						for(int i=0; i<line_end_points.size(); i++) {
							g.setColor(line_color.get(i)); //set the each time color
							if(line_state.get(i)) {
								g2.setStroke(new BasicStroke(line_size.get(i)));
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);	
							}
							else {
								dash = new BasicStroke(line_size.get(i), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f);
								g2.setStroke(dash);
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);
							}
						}	
					}
					//draw the new Line
					g.setColor(drag_color); //set the new line color
					if(Filler_Panel.state) {
						g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX));
						g.drawLine(init_x, init_y, end_x, end_y);
					}
					else {
						g2.setStroke(dash);
						g.drawLine(init_x, init_y, end_x, end_y);
					}
					
					//draw the points
					for(int i=0; i<points.size(); i++) {
							g.setColor(brush_color.get(i));
							g.fillOval( points.get(i).x,  points.get(i).y, brush_size_x.get(i), brush_size_y.get(i));
					}
					
					//draw the Oval
					if(oval_end_points != null) {
						for(int i=0; i<oval_end_points.size(); i++) {
							g.setColor(oval_color.get(i));//set the each time color
							if(oval_state.get(i)) {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.fillOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.drawOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
						}	
					}	
					
					//draw the rect
					if(rect_end_points != null) {
						for(int i=0; i<rect_end_points.size(); i++) {
							g.setColor(rect_color.get(i)); //get the each time color
							if(rect_state.get(i)) {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.fillRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.drawRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							
						}	
					}
					
					//draw the RoundRect
					if(roundRect_end_points != null) {
						for(int i=0; i<roundRect_end_points.size(); i++) {
							g.setColor(roundRect_color.get(i));//set the each time color
							if(roundRect_state.get(i)) {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.fillRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
							}
							else {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.drawRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
								}
						}	
					}
					break;
					
				case "橢圓形":
					//draw the old oval
					if(oval_end_points != null) {
						for(int i=0; i<oval_end_points.size(); i++) {
							g.setColor(oval_color.get(i));//set the each time color
							if(oval_state.get(i)) {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.fillOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.drawOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
						}	
					}
					//draw the new oval
					g.setColor(drag_color);//set the new oval color 
					if(Filler_Panel.state) {
						g.fillOval( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					else {
						g.drawOval( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					
					//draw the points
					for(int i=0; i<points.size(); i++) {
							g.setColor(brush_color.get(i));
							g.fillOval( points.get(i).x,  points.get(i).y, brush_size_x.get(i), brush_size_y.get(i));
					}
					
					//draw the Line
					if(line_end_points != null) {
						for(int i=0; i<line_end_points.size(); i++) {
							g.setColor(line_color.get(i)); //set the each time color
							if(line_state.get(i)) {
								g2.setStroke(new BasicStroke(line_size.get(i)));
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);	
							}
							else {
								dash = new BasicStroke(line_size.get(i), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f);
								g2.setStroke(dash);
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);
							}
						}	
					}
					
					//draw the rect
					if(rect_end_points != null) {
						for(int i=0; i<rect_end_points.size(); i++) {
							g.setColor(rect_color.get(i)); //get the each time color
							if(rect_state.get(i)) {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.fillRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.drawRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							
						}	
					}
					
					//draw the RoundRect
					if(roundRect_end_points != null) {
						for(int i=0; i<roundRect_end_points.size(); i++) {
							g.setColor(roundRect_color.get(i));//set the each time color
							if(roundRect_state.get(i)) {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.fillRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
							}
							else {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.drawRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
								}
						}	
					}
					break;
					
				case "矩形":
					//draw the old rect
					if(rect_end_points != null) {
						for(int i=0; i<rect_end_points.size(); i++) {
							g.setColor(rect_color.get(i)); //get the each time color
							if(rect_state.get(i)) {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.fillRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.drawRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							
						}	
					}
					
					//draw the new rect
					g.setColor(drag_color);//set the new color
					if(Filler_Panel.state) {
						g.fillRect( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					else {
						g.drawRect( init_x, init_y, end_x-init_x, end_y-init_y);
					}

					//draw the points
					for(int i=0; i<points.size(); i++) {
							g.setColor(brush_color.get(i));
							g.fillOval( points.get(i).x,  points.get(i).y, brush_size_x.get(i), brush_size_y.get(i));
					}
				
					//draw the Line
					if(line_end_points != null) {
						for(int i=0; i<line_end_points.size(); i++) {
							g.setColor(line_color.get(i)); //set the each time color
							if(line_state.get(i)) {
								g2.setStroke(new BasicStroke(line_size.get(i)));
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);	
							}
							else {
								dash = new BasicStroke(line_size.get(i), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f);
								g2.setStroke(dash);
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);
							}
						}	
					}
					
					//draw the Oval
					if(oval_end_points != null) {
						for(int i=0; i<oval_end_points.size(); i++) {
							g.setColor(oval_color.get(i));//set the each time color
							if(oval_state.get(i)) {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.fillOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.drawOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
						}	
					}
					
					//draw the RoundRect
					if(roundRect_end_points != null) {
						for(int i=0; i<roundRect_end_points.size(); i++) {
							g.setColor(roundRect_color.get(i));//set the each time color
							if(roundRect_state.get(i)) {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.fillRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
							}
							else {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.drawRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
								}
						}	
					}
					break;
					
				case "圓角矩形":
					//draw the old roundRect
					if(roundRect_end_points != null) {
						for(int i=0; i<roundRect_end_points.size(); i++) {
							g.setColor(roundRect_color.get(i));//set the each time color
							if(roundRect_state.get(i)) {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.fillRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
							}
							else {
								g2.setStroke(new BasicStroke(roundRect_size.get(i)));
								g.drawRoundRect(roundRect_init_points.get(i).x, roundRect_init_points.get(i).y, roundRect_end_points.get(i).x-roundRect_init_points.get(i).x, roundRect_end_points.get(i).y-roundRect_init_points.get(i).y, 20 ,20);
								}
						}	
					}
					//draw the new roundRect
					g.setColor(drag_color);//set the new color
					if(Filler_Panel.state) {
						g.fillRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
					}
					else {
						g.drawRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
					}
					
					
					//draw the points
					for(int i=0; i<points.size(); i++) {
							g.setColor(brush_color.get(i));
							g.fillOval( points.get(i).x,  points.get(i).y, brush_size_x.get(i), brush_size_y.get(i));
					}
				
					//draw the Line
					if(line_end_points != null) {
						for(int i=0; i<line_end_points.size(); i++) {
							g.setColor(line_color.get(i)); //set the each time color
							if(line_state.get(i)) {
								g2.setStroke(new BasicStroke(line_size.get(i)));
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);	
							}
							else {
								dash = new BasicStroke(line_size.get(i), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {15,15}, 0f);
								g2.setStroke(dash);
								g.drawLine(line_init_points.get(i).x, line_init_points.get(i).y, line_end_points.get(i).x, line_end_points.get(i).y);
							}
						}	
					}
				
				
					//draw the Oval
					if(oval_end_points != null) {
						for(int i=0; i<oval_end_points.size(); i++) {
							g.setColor(oval_color.get(i));//set the each time color
							if(oval_state.get(i)) {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.fillOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(oval_size.get(i)));
								g.drawOval(oval_init_points.get(i).x, oval_init_points.get(i).y, oval_end_points.get(i).x-oval_init_points.get(i).x, oval_end_points.get(i).y-oval_init_points.get(i).y);
							}
						}	
					}	
				
					//draw the rect
					if(rect_end_points != null) {
						for(int i=0; i<rect_end_points.size(); i++) {
							g.setColor(rect_color.get(i)); //get the each time color
							if(rect_state.get(i)) {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.fillRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
							else {
								g2.setStroke(new BasicStroke(rect_size.get(i)));
								g.drawRect(rect_init_points.get(i).x, rect_init_points.get(i).y, rect_end_points.get(i).x-rect_init_points.get(i).x, rect_end_points.get(i).y-rect_init_points.get(i).y);
							}
						}	
					}		
					break;
			}
		}	
	}
	
}
