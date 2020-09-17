package component.card.important_constructure;

import component.card.Important_Constructure;

public class NTB extends Important_Constructure{

	public NTB() {
		super("NTB", 3, 5);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
