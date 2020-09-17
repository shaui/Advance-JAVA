package component.card.infrastructure;

import component.card.Infrastructure;

public class Mackerel_Ship extends Infrastructure {

	public Mackerel_Ship() {
		super("Mackerel_Ship", 2, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
