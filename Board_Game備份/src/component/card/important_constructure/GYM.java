package component.card.important_constructure;

import component.card.Important_Constructure;

public class GYM extends Important_Constructure{

	public GYM() {
		super("GYM", 3, 5);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
