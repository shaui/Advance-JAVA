package component.card;

import component.card.important_constructure.*;

public abstract class Important_Constructure extends Card{

	private static Important_Constructure[] cardList = new Important_Constructure[]
			{new Publishing_House(), new NTB(), new TV_Station(), new Business_Center(), new GYM()};
	
	public Important_Constructure(String name, int iconNum, int maxAmount) {
		super(name, "important_constructure", iconNum, maxAmount);
	}

	public static int getNumber(Card c) {
		for(int i = 0;i < cardList.length;i++) {
			if(cardList[i].getName() == c.getName()) {
				return i;
			}
		}
		return -1;
	}
	
	public static Important_Constructure[] getCardList() {
		return cardList;
	}
}
