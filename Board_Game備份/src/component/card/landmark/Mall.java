package component.card.landmark;

import component.card.Landmark;

public class Mall extends Landmark {

	public Mall() {
		super("Mall", 9, 1);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
