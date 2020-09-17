package component.card.entertaining_facilities;

import component.card.Entertaining_Facilities;

public class Family_Restaurant extends Entertaining_Facilities {

	public Family_Restaurant() {
		super("Family_Restaurant", 1, 6);
	}

	@Override
	public int cardEffect(boolean ownRound) {
		return 0;
	}

}
