package component.card.processing_plant;

import component.card.Processing_Plant;

public class Bakery extends Processing_Plant {

	public Bakery() {
		super("Bakery", 4, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
