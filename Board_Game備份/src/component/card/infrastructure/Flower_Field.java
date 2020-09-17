package component.card.infrastructure;

import component.card.Infrastructure;

public class Flower_Field extends Infrastructure {

	public Flower_Field() {
		super("Flower_Field", 6, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
