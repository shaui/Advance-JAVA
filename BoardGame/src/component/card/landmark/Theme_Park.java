package component.card.landmark;

import component.card.Landmark;

public class Theme_Park extends Landmark {

	public Theme_Park() {
		super("Theme_Park", 9, 1);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
