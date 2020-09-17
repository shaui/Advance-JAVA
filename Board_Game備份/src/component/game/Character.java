package component.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import component.base.MyPanel;
import main.Size;

public class Character extends MyPanel{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Image c_image;
	
	public Character(int Player_number, String name, Image character) {
		this.name = name;
		c_image = character;
		setLocation(0, 108+(Player_number+1)*120);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(c_image, 0, 0, Size.getX_Scale(100), Size.getY_Scale(120), null);
		g.setFont(new Font(Font.DIALOG, Font.BOLD ,20));
		g.setColor(Color.black);
		g.drawString(name, Size.getX_Scale(110), Size.getY_Scale(60));
		int j = (int) g.getFontMetrics().getStringBounds(name, g).getWidth();
		setSize(120+j*1920/Size.getX(), 120);
	} 
}
