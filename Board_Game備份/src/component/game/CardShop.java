package component.game;

import java.awt.Color;
import java.awt.Graphics;

import component.base.CardContainer;
import component.card.*;

public class CardShop extends CardContainer{
	
	private static final long serialVersionUID = 1L;
	
	public CardShop() {
		super(true);
		for(int a = 0;a < Entertaining_Facilities.getCardList().length;a++) {
			addCardToList(Entertaining_Facilities.getCardList()[a], Entertaining_Facilities.getCardList()[a].getMaxAmount());
		}
		for(int a = 0;a < Important_Constructure.getCardList().length;a++) {
			addCardToList(Important_Constructure.getCardList()[a], Important_Constructure.getCardList()[a].getMaxAmount());
		}
		for(int a = 0;a < Infrastructure.getCardList().length;a++) {
			addCardToList(Infrastructure.getCardList()[a], Infrastructure.getCardList()[a].getMaxAmount());
		}
		for(int a = 0;a < Processing_Plant.getCardList().length;a++) {
			addCardToList(Processing_Plant.getCardList()[a], Processing_Plant.getCardList()[a].getMaxAmount());
		}
	}
	
	public void setType(String cardtype) {
		GamePanel.setChooseCard(true);
		addCardToPanel(cardtype);
	}
	
	public void checkDialog(Card type) {
		 GamePanel.getCheckPanel().setCard(type);
		 GamePanel.getCheckPanel().setVisible(true);
	}
	
	public void Buy(Card card) {
		addCardToList(card, getCardAmounts(card)-1);
		setVisible(false);
		GamePanel.setChooseCard(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
