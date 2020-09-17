package component.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import component.base.MyPanel;
import component.card.Card;
import main.Main;
import main.Size;

public class CardInfo extends MyPanel {

	private static final long serialVersionUID = 1L;
	private Card c = null;
	private Font nameF = new Font(Font.DIALOG, Font.BOLD , 30), infoF = new Font(Font.DIALOG, Font.BOLD , 20);
	private Image icon;
	private Graphics g;
	private int y = 35;
	private int point = Size.getX_Scale(10), row = 0;
	
	public CardInfo() {
		setSize(500, 200);
		setVisible(false);
	}

	public void setCardType(Card type) {
		c = type;
		loadImage();
	}
	
	private void loadImage() {
		try {
			icon = ImageIO.read(getClass().getResource("/image/cardIcon/Icon" + c.getIconNum() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.g = g;
		g.setColor(new Color(0, 0, 0, 150));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setFont(nameF);
		g.setColor(Color.white);
		Main.drawStringAtCenter(g, Main.getName(c), 250, 50);
		g.drawImage(icon, Size.getX_Scale(200)-Main.getStringHalfWidth(g, Main.getName(c)), Size.getY_Scale(10), Size.getX_Scale(50), Size.getY_Scale(50), null);
		g.setFont(infoF);
		if(c.getType() != Card.landmark) {
			Main.drawStringAtCenter(g, Main.getNumber(c), 250, 90);
			y = 35;
		}
		else {
			y = 0;
		}
		info();
	}
	
	private void info() {
		String[] s = Main.getInfo(c).split("");
		point = Size.getX_Scale(10);
		row = 0;
		for(int i = 0;i < s.length;i++) {
			int j = (int) g.getFontMetrics().getStringBounds(s[i], g).getWidth()+1;
			if(s[i].equals("$") || s[i].equals("@") || s[i].equals("!")) {
				infoIcon(s[i]);
				continue;
			}
			if(point+j >= Size.getX_Scale(500)) {
				row++;
				point = Size.getX_Scale(10);
			}
			g.drawString(s[i], point, Size.getX_Scale(90+y+row*40));
			point += j;
		}
		setSize(500, 90+y+row*40+20);
	}
	
	private void infoIcon(String s) {
		int i = 0;
		switch(s) {
		case "$":
			i = 1;
			break;
		case "!":
			i = 3;
			break;
		case "@":
			i = 4;
			break;
		}
		try {
			Image ic = ImageIO.read(getClass().getResource("/image/cardIcon/Icon" + i + ".png"));
			if(point+Size.getX_Scale(50) >= Size.getX_Scale(500)) {
				row++;
				point = Size.getX_Scale(10);
			}
			g.drawImage(ic, point, Size.getX_Scale(90+y+row*40-33), Size.getX_Scale(50), Size.getY_Scale(50), null);
			point += Size.getX_Scale(50);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
