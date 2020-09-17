package component.card.important_constructure;

import component.card.Important_Constructure;

public class Publishing_House extends Important_Constructure{

	public Publishing_House() {
		super("Publishing_House", 3, 5);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
