package component.card;

import component.card.processing_plant.*;

public abstract class Processing_Plant extends Card{
	
	private static Processing_Plant[] cardList = new Processing_Plant[]
			{new Bakery(), new Convenience_Store(), new Flower_Store(), new Food_Storage()};

	public Processing_Plant(String name, int iconNum, int maxAmount) {
		super(name, "processing_plant", iconNum, maxAmount);
	}

	public static int getNumber(Card c) {
		for(int i = 0;i < cardList.length;i++) {
			if(cardList[i].getName() == c.getName()) {
				return i;
			}
		}
		return -1;
	}
	
	public static Processing_Plant[] getCardList() {
		return cardList;
	}
}
