package component.card.landmark;

import component.card.Landmark;

public class Port extends Landmark {

	public Port() {
		super("Port", 9, 1);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
