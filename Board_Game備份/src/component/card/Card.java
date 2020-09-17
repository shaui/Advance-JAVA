package component.card;

public abstract class Card {

	private String n, t;
	private int i, ma;
	public static final String entertaining_facilities = "entertaining_facilities",
			important_constructure = "important_constructure",
			infrastructure = "infrastructure",
			landmark = "landmark",
			processing_plant = "processing_plant";

	public Card(String name, String type, int iconNum, int maxAmount) {
		n = name;
		t = type;
		i = iconNum;
		ma = maxAmount;
	}


	public String getName() {
		return n;
	}

	public String getType() {
		return t;
	}

	public int getIconNum() {
		return i;
	}

	public int getMaxAmount() {
		return ma;
	}

	public abstract int cardEffect(boolean ownRound);
}
