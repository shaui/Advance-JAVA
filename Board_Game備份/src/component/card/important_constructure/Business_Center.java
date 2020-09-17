package component.card.important_constructure;

import component.card.Important_Constructure;

public class Business_Center extends Important_Constructure{

	public Business_Center() {
		super("Business_Center", 3, 5);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
