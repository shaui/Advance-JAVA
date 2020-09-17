package component.base;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.Size;

public class MyPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public MyPanel() {
		setSize(1920, 1080);
		setLocation(0, 0);
	}

	@Override
	public void setSize(int x, int y) {
		super.setSize(Size.getX_Scale(x), Size.getY_Scale(y));
	}
	
	@Override
	public void setLocation(int x, int y) {
		super.setLocation(Size.getX_Scale(x), Size.getY_Scale(y));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
