package component.card.entertaining_facilities;

import component.card.Entertaining_Facilities;

public class Pizza extends Entertaining_Facilities {

	public Pizza() {
		super("Pizza", 1, 6);
	}
	
	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
