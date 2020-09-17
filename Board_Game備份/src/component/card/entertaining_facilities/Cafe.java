package component.card.entertaining_facilities;

import component.card.Entertaining_Facilities;

public class Cafe extends Entertaining_Facilities {

	public Cafe() {
		super("Cafe", 1, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
