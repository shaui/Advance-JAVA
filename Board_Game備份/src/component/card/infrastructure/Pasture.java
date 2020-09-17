package component.card.infrastructure;

import component.card.Infrastructure;

public class Pasture extends Infrastructure {

	public Pasture() {
		super("Pasture", 7, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
