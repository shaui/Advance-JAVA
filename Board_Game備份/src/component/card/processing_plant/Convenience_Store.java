package component.card.processing_plant;

import component.card.Processing_Plant;

public class Convenience_Store extends Processing_Plant {

	public Convenience_Store() {
		super("Convenience_Store", 4, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
