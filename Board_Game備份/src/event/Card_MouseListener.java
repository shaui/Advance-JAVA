package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import component.game.CardShop;
import component.game.CardInfo;
import component.game.GamePanel;
import component.card.Card;
import component.card.Card_Panel;
import main.Size;

public class Card_MouseListener implements MouseListener, MouseMotionListener{
	
	private Card_Panel c;
	private CardInfo ci = GamePanel.getCardInfo();
	private CardShop cc;
	private boolean buyState = false;
	
	public Card_MouseListener(Card_Panel card) {
		c = card;
	}
	
	public void buyStateIsTrue(CardShop container) {
		buyState = true;
		cc = container;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(c.getCard().getType() == Card.landmark) {
			GamePanel.setLandmark(true);
		}
 		if(GamePanel.getInfoState()) {
			ci.setCardType(c.getCard());
			ci.setVisible(true);
			ci.setLocation((c.getLocation().x+e.getX())*1920/Size.getX()-250, (c.getLocation().y+e.getY())*1080/Size.getY());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(c.getCard().getType() == Card.landmark) {
			GamePanel.setLandmark(false);
		}
		ci.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(buyState && !GamePanel.getCheckPanel().isVisible() && c.getAmount() > 0) {
			cc.checkDialog(c.getCard());
			ci.setVisible(false);
			GamePanel.setInfoState(false);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(GamePanel.getInfoState()) {
			ci.setLocation((c.getLocation().x+e.getX())*1920/Size.getX()-250, (c.getLocation().y+e.getY())*1080/Size.getY());
		}
	}

}
