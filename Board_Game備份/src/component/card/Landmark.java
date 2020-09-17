package component.card;

import component.card.landmark.*;

public abstract class Landmark extends Card{
	
	private static Landmark[] cardList = new Landmark[]
			{new Port(), new Airport(), new Theme_Park(), new Mall(), new Train_Station(), new Radio_Station()};

	public Landmark(String name, int iconNum, int maxAmount) {
		super(name, "landmark", iconNum, maxAmount);
	}

	public static int getNumber(Card c) {
		for(int i = 0;i < cardList.length;i++) {
			if(cardList[i].getName() == c.getName()) {
				return i;
			}
		}
		return -1;
	}
	
	public static Landmark[] getCardList() {
		return cardList;
	}
}
