package component.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import component.card.Card;
import component.card.Card_Panel;

public abstract class CardContainer extends MyPanel {

	private static final long serialVersionUID = 1L;
	private HashMap<Card, Integer> cardList = new HashMap<>();
	private boolean buyState;

	public CardContainer(boolean allowPurchase) {
		setLayout(null);
		setVisible(false);
		setSize(1920, 1080);
		setLocation(0, 0);
		buyState = allowPurchase;
	}
	
	protected void addCardToList(Card card, int amounts) {
		cardList.put(card, amounts);
	}
	
	protected void addCardToPanel(String type) {
		removeAll();
		switch(type) {
		case Card.entertaining_facilities:
			addCard(type);
			break;
		case Card.important_constructure:
			addCard(type);
			break;
		case Card.infrastructure:
			addCard(type);
			break;
		case Card.processing_plant:
			addCard(type);
			break;
		case "All":
			addCard(Card.infrastructure);
			addCard(Card.processing_plant);
			addCard(Card.entertaining_facilities);
			addCard(Card.important_constructure);
			break;
		}
	}
	
	private void addCard(String type) {
		Iterator<Entry<Card, Integer>> cardIter = cardList.entrySet().iterator();
		while(cardIter.hasNext()) {
			Entry<Card, Integer> e = cardIter.next();
			if(e.getKey().getType() == type) {
				Card_Panel c = new Card_Panel(e.getKey(), e.getValue(), 158+getComponentCount()*272, 216+getComponentCount()/6*594);
				if(buyState) {
					c.buyStateIstrue();
				}
				add(c);
			}
		}
		setVisible(true);
	}

	protected int getCardAmounts(Card card) {
		return cardList.get(card);
	}
	
}
