package component.card.landmark;

import component.card.Landmark;

public class Airport extends Landmark {

	public Airport() {
		super("Airport", 9, 1);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
