package component.card;

import component.card.entertaining_facilities.*;

public abstract class Entertaining_Facilities extends Card{
	
	private static Entertaining_Facilities[] cardList = new Entertaining_Facilities[] 
			{new Cafe(), new Sushi(), new Pizza(), new Hamburger(), new Family_Restaurant()};

	public Entertaining_Facilities(String name, int iconNum, int maxAmount) {
		super(name, "entertaining_facilities", iconNum, maxAmount);
	}

	public static int getNumber(Card c) {
		for(int i = 0;i < cardList.length;i++) {
			if(cardList[i].getName() == c.getName()) {
				return i;
			}
		}
		return -1;
	}
	
	public static Entertaining_Facilities[] getCardList() {
		return cardList;
	}
}
