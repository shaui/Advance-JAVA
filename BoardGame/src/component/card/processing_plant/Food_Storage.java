package component.card.processing_plant;

import component.card.Processing_Plant;

public class Food_Storage extends Processing_Plant {

	public Food_Storage() {
		super("Food_Storage", 5, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
