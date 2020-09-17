package component.card.landmark;

import component.card.Landmark;

public class Train_Station extends Landmark {

	public Train_Station() {
		super("Train_Station", 9, 1);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
