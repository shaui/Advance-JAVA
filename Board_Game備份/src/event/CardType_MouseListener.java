package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import component.game.CardShop;
import component.game.CardType_Panel;
import component.game.GamePanel;
import component.card.Card;
import main.Size;

public class CardType_MouseListener implements MouseListener {
	
	private CardType_Panel c;
	
	public CardType_MouseListener(CardType_Panel c) {
		this.c = c;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		c.setEntered(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		c.setEntered(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX(), y = e.getY(), 
			rx = Size.getX_Scale(20), ry = Size.getY_Scale(20), 
			cardx = Size.getX_Scale(230), cardy = Size.getY_Scale(324),
			ix = Size.getY_Scale(10);
		CardShop cc = GamePanel.getCardContainer();
		if(x >= rx && x <= rx+cardx && y >= ry && y <= ry+cardy) {
			cc.setType(Card.infrastructure);
		}
		else if(x >= rx+cardx+ix && x <= rx+cardx*2+ix && y >= ry && y <= ry+cardy) {
			cc.setType(Card.processing_plant);
		}
		else if(x >= rx+cardx*2+ix*2 && x <= rx+cardx*3+ix*2 && y >= ry && y <= ry+cardy) {
			cc.setType(Card.entertaining_facilities);	
		}
		else if(x >= rx+cardx*3+ix*3 && x <= rx+cardx*4+ix*3 && y >= ry && y <= ry+cardy) {
			cc.setType(Card.important_constructure);
		}
		GamePanel.getCheckPanel().setVisible(false);
	}

}
