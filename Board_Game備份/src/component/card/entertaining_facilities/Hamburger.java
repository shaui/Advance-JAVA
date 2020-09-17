package component.card.entertaining_facilities;

import component.card.Entertaining_Facilities;

public class Hamburger extends Entertaining_Facilities {

	public Hamburger() {
		super("Hamburger", 1, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
