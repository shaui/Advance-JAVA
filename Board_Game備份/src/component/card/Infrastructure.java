package component.card;

import component.card.infrastructure.*;

public abstract class Infrastructure extends Card{

	private static Infrastructure[] cardList = new Infrastructure[]
			{new Wheat_Field(), new Pasture(), new Forest(), new Flower_Field(), new Mackerel_Ship(), new Tuna_Ship()};
	public Infrastructure(String name, int iconNum, int maxAmount) {
		super(name, "infrastructure", iconNum, maxAmount);
	}

	public static int getNumber(Card c) {
		for(int i = 0;i < cardList.length;i++) {
			if(cardList[i].getName() == c.getName()) {
				return i;
			}
		}
		return -1;
	}
	
	public static Infrastructure[] getCardList() {
		return cardList;
	}
}
