package component.card.infrastructure;

import component.card.Infrastructure;

public class Forest extends Infrastructure {

	public Forest() {
		super("Forest", 8, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
