package component.card.infrastructure;

import component.card.Infrastructure;

public class Wheat_Field extends Infrastructure {

	public Wheat_Field() {
		super("Wheat_Field", 6, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
