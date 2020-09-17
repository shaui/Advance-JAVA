package component.card.important_constructure;

import component.card.Important_Constructure;

public class TV_Station extends Important_Constructure{

	public TV_Station() {
		super("TV_Station", 3, 5);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
