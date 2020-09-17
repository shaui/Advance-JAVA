package component.card.infrastructure;

import component.card.Infrastructure;

public class Tuna_Ship extends Infrastructure {

	public Tuna_Ship() {
		super("Tuna_Ship", 2, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
