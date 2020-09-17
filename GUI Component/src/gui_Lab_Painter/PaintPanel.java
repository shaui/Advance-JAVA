/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;

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
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*繪圖區*/
public class PaintPanel extends JPanel{
	//the mouse coordinates
	private JLabel mouse_site;
	
	//record current tool order state
	private ArrayList<String> locate_state = new ArrayList<>();

	//Brush's Data
	private ArrayList<Point> points = new ArrayList<>(); 
	private ArrayList<Integer> brush_size_x = new ArrayList<>();
	private ArrayList<Integer> brush_size_y = new ArrayList<>();
	private ArrayList<Color> brush_fore_color = new ArrayList<>();
	//count the points each time used
	private static int count = 0;
	//store each time count
	private ArrayList<Integer> countList = new ArrayList<>();
	
	//Straight Line Data
	private ArrayList<Point> line_init_points = new ArrayList<>(); 
	private ArrayList<Point> line_end_points = new ArrayList<>();
	private ArrayList<Integer> line_size = new ArrayList<>();
	private ArrayList<Boolean> line_state = new ArrayList<>();	
	private ArrayList<Color> line_fore_color = new ArrayList<>();
	
	//Oval Data
	private ArrayList<Integer> oval_data = new ArrayList<>();
	private ArrayList<Boolean> oval_state = new ArrayList<>();
	private ArrayList<Color> oval_fore_color = new ArrayList<>();
	private ArrayList<Color> oval_back_color = new ArrayList<>();
	
	//Rect Data
	private ArrayList<Integer> rect_data = new ArrayList<>();
	private ArrayList<Boolean> rect_state = new ArrayList<>();
	private ArrayList<Color> rect_fore_color = new ArrayList<>();
	private ArrayList<Color> rect_back_color = new ArrayList<>();
	
	//RoundRect Data
	private ArrayList<Integer> roundRect_data = new ArrayList<>();
	private ArrayList<Boolean> roundRect_state = new ArrayList<>();
	private ArrayList<Color> roundRect_fore_color = new ArrayList<>();
	private ArrayList<Color> roundRect_back_color = new ArrayList<>();
	
	//the current size
	public static int sizeX = 6;
	public static int sizeY = 6;
	
	//the current "initial" and "end" x,y
	private int init_x;
	private int init_y;
	private int end_x;
	private int end_y;
	
	//the temp x,y to judge the coordinate change
	private int temp_x;
	private int temp_y;
	
	//the current color
	private Color drag_fore_color;
	private Color drag_back_color;
	
	public PaintPanel()
	{
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		//Frame最下面的註解
		mouse_site = new JLabel("指標位置 : (0,0)");
		mouse_site.setForeground(Color.WHITE);
		mouse_site.setBackground(Color.BLACK);
		mouse_site.setOpaque(true);
		add(mouse_site, BorderLayout.SOUTH);
		
		//設定監聽器
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
			//set the current color
			if(Btn_Panel.state == "橡皮擦") {
				drag_fore_color = Color.WHITE;
				drag_back_color = Color.WHITE;
			}
			else {
				drag_fore_color = (Btn_Panel.fg_color) != null ? (Btn_Panel.fg_color) : Color.BLACK;
				drag_back_color = (Btn_Panel.bg_color) != null ? (Btn_Panel.bg_color) : Color.BLACK;
			}
			//set the current data
			switch (Paint_Tool_Panel.tool) {
				case "筆刷":
					//reset the count
					count = 0;
					break;
					
				case "直線":
					line_init_points.add(e.getPoint());
					init_x = e.getX(); //取得每次最新點擊時的x點
					init_y = e.getY(); //取得每次最新點擊時的Y點				
					line_size.add(Brush_Size_Panel.sizeX); //取得當前直線粗細
					line_state.add(Filler_Panel.state); //get the state(fill or unfill) now
					break;
					
				case "橢圓形":
					//the initial or end is determine by the direction you drag
					init_x = e.getX(); 
					init_y = e.getY(); 
					temp_x = e.getX(); //get the temporary x point
					temp_y = e.getY(); //get the temporary y point
					oval_state.add(Filler_Panel.state);
					break;
					
				case "矩形":
					init_x = e.getX(); 
					init_y = e.getY(); 
					temp_x = e.getX(); //get the temporary x point
					temp_y = e.getY(); //get the temporary y point
					rect_state.add(Filler_Panel.state);
					break;
					
				case "圓角矩形":
					init_x = e.getX(); 
					init_y = e.getY(); 
					temp_x = e.getX(); //get the temporary x point
					temp_y = e.getY(); //get the temporary y point
					roundRect_state.add(Filler_Panel.state);
					break;
			}	
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//store the each time data
			switch (Paint_Tool_Panel.tool) {
			case "筆刷":
				countList.add(count);
				break;
			case "直線":
				line_end_points.add(e.getPoint());
				if(Btn_Panel.state == "橡皮擦") {
					line_fore_color.add(Color.WHITE);
				}
				else {
					line_fore_color.add(drag_fore_color);
				}
				locate_state.add("直線");
				break;
			case "橢圓形":
				oval_data.add(Brush_Size_Panel.sizeX); //取得當前直線粗細
				oval_data.add(init_x);
				oval_data.add(init_y);
				oval_data.add(end_x);
				oval_data.add(end_y);
				if(Btn_Panel.state == "橡皮擦") {
					oval_fore_color.add(Color.WHITE);
					oval_back_color.add(Color.WHITE);
				}
				else {
					oval_fore_color.add(drag_fore_color);
					oval_back_color.add(drag_back_color);
				}
				locate_state.add("橢圓形");
				break;
			case "矩形":
				rect_data.add(Brush_Size_Panel.sizeX); //取得當前直線粗細
				rect_data.add(init_x);
				rect_data.add(init_y);
				rect_data.add(end_x);
				rect_data.add(end_y);
				if(Btn_Panel.state == "橡皮擦") {
					rect_fore_color.add(Color.WHITE);
					rect_back_color.add(Color.WHITE);
				}
				else {
					rect_fore_color.add(drag_fore_color);
					rect_back_color.add(drag_back_color);
				}
				locate_state.add("矩形");
				break;
			case "圓角矩形":
				roundRect_data.add(Brush_Size_Panel.sizeX); //取得當前直線粗細
				roundRect_data.add(init_x);
				roundRect_data.add(init_y);
				roundRect_data.add(end_x);
				roundRect_data.add(end_y);
				if(Btn_Panel.state == "橡皮擦") {
					roundRect_fore_color.add(drag_fore_color);
					roundRect_back_color.add(drag_back_color);
				}
				else {
					roundRect_fore_color.add(drag_fore_color);
					roundRect_back_color.add(drag_back_color);
				}
				locate_state.add("圓角矩形");
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
		
		@Override
		public void mouseDragged(MouseEvent e){
			//set or store the current data
			switch (Paint_Tool_Panel.tool) {
				case "筆刷":
					points.add(e.getPoint());
					count++;
					brush_size_x.add(Brush_Size_Panel.sizeX);
					brush_size_y.add(Brush_Size_Panel.sizeY);
					if(Btn_Panel.state == "橡皮擦") {
						brush_fore_color.add(Color.WHITE); //eraser effect
					}
					else {
						brush_fore_color.add(drag_fore_color); //default color
					}
					locate_state.add("筆刷");
					break;
				case "直線":
					end_x = e.getPoint().x; //動態取得drag時最後的點x
					end_y = e.getPoint().y; //動態取得drag時最後的點y
					break;
				case "橢圓形":
					//if the x is small then the initial x, the left-top corner's x will be change
					if(e.getPoint().x <= temp_x) {
						init_x = e.getPoint().x;
						end_x = temp_x;
					}
					else {
						init_x = temp_x;
						end_x = e.getPoint().x;
					}
					//if the y is small then the initial y, the left-top corner's y will be change
					if(e.getPoint().y <= temp_y) {
						init_y = e.getPoint().y;
						end_y = temp_y;
					}
					else {
						init_y = temp_y;
						end_y = e.getPoint().y;
					}
					break;
					
				case "矩形":
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
					break;
					
				case "圓角矩形":
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
					break;
			}
			repaint();
		}
	}
	//remove the end data to get the effect of last-step
	public void removeEnd() {
		//check the last state and remove its data
		switch (locate_state.get(locate_state.size()-1)) {
			case "筆刷":
				for(int i=0; i<countList.get(countList.size()-1); i++) {
					locate_state.remove(locate_state.size()-1);
					points.remove(points.size()-1);
					brush_size_x.remove(brush_size_x.size()-1);
					brush_size_y.remove(brush_size_y.size()-1);
					brush_fore_color.remove(brush_fore_color.size()-1);
				}
				countList.remove(countList.size()-1);
				break;
			case "直線":
				locate_state.remove(locate_state.size()-1);
				line_init_points.remove(line_init_points.size()-1);
				line_end_points.remove(line_end_points.size()-1);
				line_size.remove(line_size.size()-1);
				line_state.remove(line_state.size()-1);
				line_fore_color.remove(line_fore_color.size()-1);
				break;
			case "橢圓形":
				locate_state.remove(locate_state.size()-1);
				for(int i=0; i<5; i++) {
					oval_data.remove(oval_data.size()-1);
				}
				oval_state.remove(oval_state.size()-1);
				oval_fore_color.remove(oval_fore_color.size()-1);
				oval_back_color.remove(oval_back_color.size()-1);
				break;
			case "矩形":
				locate_state.remove(locate_state.size()-1);
				for(int i=0; i<5; i++) {
					rect_data.remove(rect_data.size()-1);
				}
				rect_state.remove(rect_state.size()-1);
				rect_fore_color.remove(rect_fore_color.size()-1);
				rect_back_color.remove(rect_back_color.size()-1);
				break;
			case "圓角矩形":
				locate_state.remove(locate_state.size()-1);
				for(int i=0; i<5; i++) {
					roundRect_data.remove(roundRect_data.size()-1);
				}
				roundRect_state.remove(roundRect_state.size()-1);
				roundRect_fore_color.remove(roundRect_fore_color.size()-1);
				roundRect_back_color.remove(roundRect_back_color.size()-1);
				break;
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		//last-step function
		if(Btn_Panel.state == "上一步"){
			super.paintComponent(g);
			removeEnd();
			Graphics2D g2 = (Graphics2D)g;
			paintAll(g, g2);
			if(drag_fore_color == Color.WHITE || drag_back_color == Color.WHITE) {
				Btn_Panel.state = "橡皮擦";
			}
			else {
				Btn_Panel.state = "";
			}
			
		}
		//clear all function
		else if(Btn_Panel.state == "清除畫面") {
			//clear the brush data
			points.clear();
			brush_size_x.clear();
			brush_size_y.clear();
			brush_fore_color.clear();
			
			//clear the line data
			line_init_points.clear();
			line_end_points.clear();
			line_size.clear();
			line_state.clear();
			line_fore_color.clear();
			
			//clear the oval data
			oval_data.clear();
			oval_state.clear();
			oval_fore_color.clear();
			oval_back_color.clear();
			
			//clear the rect data
			rect_data.clear();
			rect_state.clear();
			rect_fore_color.clear();
			rect_back_color.clear();
			
			//clear the roundRect data
			roundRect_data.clear();
			roundRect_state.clear();
			roundRect_fore_color.clear();
			roundRect_back_color.clear();
			
			//clear the counter
			locate_state.clear();
			
			super.paintComponent(g);
			Btn_Panel.state = "";
		}
		//draw picture function
		else {
			super.paintComponent(g);
			//set the attributes will be uesd
			Graphics2D g2 = (Graphics2D)g;  
			BasicStroke dash;
			
			//paint all the stored data
			paintAll(g, g2);
			

			//draw the current picture
			switch (Paint_Tool_Panel.tool) {
				case "直線":
					g.setColor(drag_fore_color); //set the new line color
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
				case "橢圓形":
					g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX)); //set the current size
					if(Filler_Panel.state) {
						g.setColor(drag_back_color); //set the new back_color 
						g.fillOval( init_x, init_y, end_x-init_x, end_y-init_y);
						g.setColor(drag_fore_color); //set the new fore_color 
						g.drawOval( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					else {
						g.setColor(drag_fore_color);
						g.drawOval( init_x, init_y, Math.abs(end_x-init_x), Math.abs(end_y-init_y) );
					}
					break;
				case "矩形":
					g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX)); //set the current size
					g.setColor(drag_fore_color);//set the new color
					if(Filler_Panel.state) {
						g.setColor(drag_back_color); //set the new back_color 
						g.fillRect( init_x, init_y, end_x-init_x, end_y-init_y);
						g.setColor(drag_fore_color); //set the new fore_color 
						g.drawRect( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					else {
						g.setColor(drag_fore_color);
						g.drawRect( init_x, init_y, end_x-init_x, end_y-init_y);
					}
					break;
				case "圓角矩形":
					g2.setStroke(new BasicStroke(Brush_Size_Panel.sizeX)); //set the current size	
					if(Filler_Panel.state) {
						g.setColor(drag_back_color); //set the new back_color 
						g.fillRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
						g.setColor(drag_fore_color); //set the new fore_color 
						g.drawRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
					}
					else {
						g.setColor(drag_fore_color);
						g.drawRoundRect(init_x, init_y, end_x-init_x, end_y-init_y, 20, 20);
					}
					break;
			}
		}
	}
	//draw the stored data
	public void paintAll(Graphics g, Graphics2D g2) {
		BasicStroke dash;
		//All component counter
		Iterator<String> counter = locate_state.iterator();
		
		//point iterator
		Iterator<Point> it_points = points.iterator();
		Iterator<Integer> it_brush_size_x = brush_size_x.iterator();
		Iterator<Integer> it_brush_size_y = brush_size_y.iterator();
		Iterator<Color> it_brush_fore_color = brush_fore_color.iterator();
		
		//line iterator
		Iterator<Point> it_line_init_points = line_init_points.iterator();
		Iterator<Point> it_line_end_points = line_end_points.iterator();
		Iterator<Integer> it_line_size = line_size.iterator();
		Iterator<Boolean> it_line_state = line_state.iterator();
		Iterator<Color> it_line_fore_color = line_fore_color.iterator();
		
		//oval iterator
		//Iterator<Point> it_oval_init_points = oval_init_points.iterator();
		//Iterator<Point> it_oval_end_points = oval_end_points.iterator();
		
		Iterator<Integer> it_oval_data = oval_data.iterator();
		Iterator<Boolean> it_oval_state = oval_state.iterator();
		Iterator<Color> it_oval_fore_color = oval_fore_color.iterator();
		Iterator<Color> it_oval_back_color = oval_back_color.iterator();
		
		//rect iterator
		Iterator<Integer> it_rect_data = rect_data.iterator();
		Iterator<Boolean> it_rect_state = rect_state.iterator();
		Iterator<Color> it_rect_fore_color = rect_fore_color.iterator();
		Iterator<Color> it_rect_back_color = rect_back_color.iterator();
		
		//roundRect iterator
		Iterator<Integer> it_roundRect_data = roundRect_data.iterator();
		Iterator<Boolean> it_roundRect_state = roundRect_state.iterator();
		Iterator<Color> it_roundRect_fore_color = roundRect_fore_color.iterator();
		Iterator<Color> it_roundRect_back_color = roundRect_back_color.iterator();
		
		//paint all the stored data
		while(counter.hasNext()) {
			switch ( counter.next() ) {
				case "筆刷":
						g.setColor( it_brush_fore_color.next() );
						Point brush_p = it_points.next();
						g.fillOval( brush_p.x,  brush_p.y, it_brush_size_x.next(), it_brush_size_y.next() );
						break;
				case "直線":
					g.setColor( it_line_fore_color.next()); //set the each time color
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
				case "橢圓形":
					if(it_oval_state.next()) {
						g2.setStroke( new BasicStroke( it_oval_data.next() ) );
						int oval_init_x = it_oval_data.next();
						int oval_init_y = it_oval_data.next();
						int oval_end_x = it_oval_data.next();
						int oval_end_y = it_oval_data.next();
						g.setColor(it_oval_back_color.next()); //set the each time color
						g.fillOval(oval_init_x, oval_init_y , Math.abs( oval_end_x-oval_init_x ) , Math.abs( oval_end_y - oval_init_y));
						g.setColor(it_oval_fore_color.next()); //set the each time color
						g.drawOval(oval_init_x, oval_init_y , Math.abs( oval_end_x-oval_init_x ) , Math.abs( oval_end_y - oval_init_y));
					}
					else {
						g2.setStroke( new BasicStroke( it_oval_data.next() ) );
						int oval_init_x = it_oval_data.next();
						int oval_init_y = it_oval_data.next();
						int oval_end_x = it_oval_data.next();
						int oval_end_y = it_oval_data.next();
						Color c = it_oval_back_color.next(); //also have to use this in order to keep the counter is right
						g.setColor(it_oval_fore_color.next()); //get the each time color
						g.drawOval(oval_init_x, oval_init_y , Math.abs( oval_end_x-oval_init_x ) , Math.abs( oval_end_y - oval_init_y));
					}
					break;
				case "矩形":
					if(it_rect_state.next()) {
						g2.setStroke(new BasicStroke(it_rect_data.next()));
						int rect_init_x = it_rect_data.next();
						int rect_init_y = it_rect_data.next();
						int rect_end_x = it_rect_data.next();
						int rect_end_y = it_rect_data.next();
						g.setColor(it_rect_back_color.next()); //get the each time color
						g.fillRect(rect_init_x, rect_init_y, rect_end_x-rect_init_x, rect_end_y-rect_init_y);
						g.setColor(it_rect_fore_color.next()); //get the each time color
						g.drawRect(rect_init_x, rect_init_y, rect_end_x-rect_init_x, rect_end_y-rect_init_y);
					}
					else {
						g2.setStroke(new BasicStroke(it_rect_data.next()));
						int rect_init_x = it_rect_data.next();
						int rect_init_y = it_rect_data.next();
						int rect_end_x = it_rect_data.next();
						int rect_end_y = it_rect_data.next();
						Color c = it_rect_back_color.next(); //also have to use this in order to keep the counter is right
						g.setColor(it_rect_fore_color.next()); //get the each time color
						g.drawRect(rect_init_x, rect_init_y, rect_end_x-rect_init_x, rect_end_y-rect_init_y);
					}
					break;
				case "圓角矩形":
					if(it_roundRect_state.next()) {
						g2.setStroke(new BasicStroke(it_roundRect_data.next()));
						int roundRect_init_x = it_roundRect_data.next();
						int roundRect_init_y = it_roundRect_data.next();
						int roundRect_end_x = it_roundRect_data.next();
						int roundRect_end_y = it_roundRect_data.next();
						g.setColor(it_roundRect_back_color.next());//set the each time color
						g.fillRoundRect(roundRect_init_x, roundRect_init_y, roundRect_end_x-roundRect_init_x, roundRect_end_y-roundRect_init_y, 20 ,20);
						g.setColor(it_roundRect_fore_color.next());//set the each time color
						g.drawRoundRect(roundRect_init_x, roundRect_init_y, roundRect_end_x-roundRect_init_x, roundRect_end_y-roundRect_init_y, 20 ,20);
					}
					else {
						g2.setStroke(new BasicStroke(it_roundRect_data.next()));
						int roundRect_init_x = it_roundRect_data.next();
						int roundRect_init_y = it_roundRect_data.next();
						int roundRect_end_x = it_roundRect_data.next();
						int roundRect_end_y = it_roundRect_data.next();
						Color c = it_roundRect_back_color.next();//also have to use this in order to keep the counter is right
						g.setColor(it_roundRect_fore_color.next());//set the each time color
						g.drawRoundRect(roundRect_init_x, roundRect_init_y, roundRect_end_x-roundRect_init_x, roundRect_end_y-roundRect_init_y, 20 ,20);
					}
					break;
			}
		}	
	}
	
}
