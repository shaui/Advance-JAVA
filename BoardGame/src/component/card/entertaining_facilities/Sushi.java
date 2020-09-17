package component.card.entertaining_facilities;

import component.card.Entertaining_Facilities;

public class Sushi extends Entertaining_Facilities {

	public Sushi() {
		super("Sushi", 1, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
