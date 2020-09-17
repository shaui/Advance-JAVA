package component.card.processing_plant;

import component.card.Processing_Plant;

public class Flower_Store extends Processing_Plant {

	public Flower_Store() {
		super("Flower_Store", 4, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
