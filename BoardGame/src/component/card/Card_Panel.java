package component.card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.imageio.ImageIO;

import component.base.MyPanel;
import component.game.GamePanel;
import event.Card_MouseListener;
import main.Main;
import main.Size;

public class Card_Panel extends MyPanel {

	private static final long serialVersionUID = 1L;
	private Image coin, bg;
	private Card card;
	private Font nameFont = new Font(Font.DIALOG, Font.BOLD ,20), coinFont = new Font(Font.DIALOG, Font.BOLD ,18);
	private Card_MouseListener m = new Card_MouseListener(this);
	private int ca;
	
	public Card_Panel(Card c, int cardAmount, int x, int y) {
		card = c;
		ca = cardAmount;
		loadImage();
		setSize(230, 324);
		setLocation(x, y);
		addMouseListener(m);
		addMouseMotionListener(m);
	}
	
	public Card getCard() {
		return card;
	}
	
	public int getAmount() {
		return ca;
	}
	
	public void buyStateIstrue() {
		m.buyStateIsTrue(GamePanel.getCardContainer());
	}
	
	private void loadImage() {
		try {
			coin = ImageIO.read(getClass().getResource("/image/cardIcon/Coin.png"));
			bg = ImageIO.read(getClass().getResource("/image/cardBG/" + card.getType() + "/" + card.getName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Point getLocation() {
		if(card.getType() == Card.landmark) {
			return new Point(super.getLocation().x+Size.getX_Scale(1920/2-735), super.getLocation().y+GamePanel.getLandmark_y());
		}
		return super.getLocation();
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		typeColor(g);
		g.fillRect(0, 0, Size.getX_Scale(230), Size.getY_Scale(50));
		g.setColor(Color.black);
		g.setFont(nameFont);
		g.drawString(Main.getName(card), Size.getX_Scale(50), Size.getY_Scale(32));
		if(ca <= 0) {
			bg = Main.ColorToGray(bg);
		}
		g.drawImage(bg, 0, Size.getY_Scale(50), Size.getX_Scale(230), Size.getY_Scale(274), null);
		g.drawImage(coin, Size.getX_Scale(5), Size.getY_Scale(5), Size.getX_Scale(40), Size.getY_Scale(40), null);
		g.setFont(coinFont);
		if(Main.getMoney(card).length() > 1) {
			g.drawString(Main.getMoney(card), Size.getX_Scale(10), Size.getY_Scale(34));
		}
		else {
			g.drawString(Main.getMoney(card), Size.getX_Scale(17), Size.getY_Scale(34));
		}
		if(ca > 1) {
			g.setFont(nameFont);
			g.setColor(Color.darkGray);
			int j = (int) g.getFontMetrics().getStringBounds(ca + "", g).getWidth();
			g.drawString(ca + "",  Size.getX_Scale(225)-j,  Size.getY_Scale(320));
			g.setColor(Color.gray);
			g.drawString(ca + "",  Size.getX_Scale(225)-j-2,  Size.getY_Scale(320));
		}
		if(ca <= 0) {
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRect(0, 0, Size.getX_Scale(230), Size.getY_Scale(50));
			g.setFont(nameFont);
			g.setColor(Color.darkGray);
			int j = (int) g.getFontMetrics().getStringBounds(ca + "", g).getWidth();
			g.drawString(ca + "",  Size.getX_Scale(225)-j,  Size.getY_Scale(320));
			g.setColor(Color.red);
			g.drawString(ca + "",  Size.getX_Scale(225)-j-2,  Size.getY_Scale(320));
		}
	}
	
	private void typeColor(Graphics g) {
		switch(card.getType()) {
		case "entertaining_facilities":
			g.setColor(new Color(255, 0, 64));
			break;
		case "important_constructure":
			g.setColor(new Color(158, 47, 225));
			break;
		case "infrastructure":
			g.setColor(new Color(0, 176, 240));
			break;
		case "landmark":
			g.setColor(new Color(255, 255, 0));
			break;
		case "processing_plant":
			g.setColor(new Color(43, 230, 70));
			break;
		}
	}

}
