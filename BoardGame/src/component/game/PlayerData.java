package component.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import component.card.Card;

public class PlayerData {
	
	private HashMap<Card, Integer> cardList = new HashMap<>();
	private int money = 0;
	private boolean[] ownLandmark = new boolean[] {false, false, false, false, false, false};
	private boolean ownRound = false;

	public PlayerData() {
	}
	
	public void setOwnRound(boolean b) {
		ownRound = b;
	}
	
	private void changeMoney() {
		Iterator<Entry<Card, Integer>> i = cardList.entrySet().iterator();
		while(i.hasNext()) {
			Entry<Card, Integer> e = i.next();
			money += e.getKey().cardEffect(ownRound);
		}
	}
}
