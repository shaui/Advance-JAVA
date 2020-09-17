package component.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import component.base.MyPanel;
import component.card.Card;
import component.card.entertaining_facilities.Cafe;
import main.Main;
import main.Size;

public class CheckPanel extends MyPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private Card c = new Cafe();
	private Font checkF = new Font(Font.DIALOG, Font.BOLD , 30), itemF = new Font(Font.DIALOG, Font.BOLD , 20);
	private CardShop cc;

	public CheckPanel(CardShop container) {
		cc = container;
		setSize(460, 324);
		setLocation((int) ((1920-460)/2), (int) ((1080-324)/2));
		addMouseListener(this);
		setVisible(false);
	}
	
	public void setCard(Card card) {
		c = card;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(new Color(0, 0, 0, 150));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.red);
		g2.fill(new Ellipse2D.Double(Size.getX_Scale(100), Size.getY_Scale(220), Size.getY_Scale(85), Size.getY_Scale(85)));
		g.setColor(Color.green);
		g2.fill(new Ellipse2D.Double(Size.getX_Scale(275), Size.getY_Scale(220), Size.getY_Scale(85), Size.getY_Scale(85)));
		g.setColor(Color.white);
		g.setFont(checkF);
		Main.drawStringAtCenter(g, "是否確認購買", 230, 50);
		g.setFont(itemF);
		Main.drawStringAtCenter(g, Main.getName(c), 230, 120);
		Main.drawStringAtCenter(g, Main.getMoney(c)+" 金幣", 230, 160);
		g.drawString("N", Size.getX_Scale(131), Size.getY_Scale(273));
		g.drawString("Y", Size.getX_Scale(308), Size.getY_Scale(273));
	}

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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(new Ellipse2D.Double(Size.getX_Scale(100), Size.getY_Scale(220), Size.getY_Scale(85), Size.getY_Scale(85)).contains(e.getX(), e.getY())) {	
			this.setVisible(false);
			GamePanel.setInfoState(true);
		}
		if(new Ellipse2D.Double(Size.getX_Scale(275), Size.getY_Scale(220), Size.getY_Scale(85), Size.getY_Scale(85)).contains(e.getX(), e.getY())) {
			cc.Buy(c);
			this.setVisible(false);
			GamePanel.setInfoState(true);
		}
	}

}
