package component.card.landmark;

import component.card.Landmark;

public class Radio_Station extends Landmark {

	public Radio_Station() {
		super("Radio_Station", 9, 1);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
