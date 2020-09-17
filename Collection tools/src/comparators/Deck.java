package comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Deck {

	public static void main(String[] args) {
		ArrayList<Cards> c = new ArrayList<>();
		Random r = new Random();
		c.add(new Cards(r.nextInt(4),r.nextInt(13)+1));
		c.add(new Cards(r.nextInt(4),r.nextInt(13)+1));
		c.add(new Cards(r.nextInt(4),r.nextInt(13)+1));
		c.add(new Cards(r.nextInt(4),r.nextInt(13)+1));
		c.add(new Cards(r.nextInt(4),r.nextInt(13)+1));
		c.add(new Cards(r.nextInt(4),r.nextInt(13)+1));
		
		Collections.sort(c, new CardComparator());
		
		Iterator<Cards> cardList = c.iterator();
		while(cardList.hasNext()){
			Cards currentCard = cardList.next();
			System.out.println(currentCard.getSuit() + " " + currentCard.getPoint());
		}

	}

}
