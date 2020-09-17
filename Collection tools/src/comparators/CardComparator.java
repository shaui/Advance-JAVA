package comparators;

import java.util.Comparator;

public class CardComparator implements Comparator<Cards>{

	public int compare(Cards c1, Cards c2) {
		if(c1.getPoint() != c2.getPoint()) {
			return c1.getPoint() - c2.getPoint();
		}
		
		if(c1.getsuitOrder() != c2.getsuitOrder()) {
			return c1.getsuitOrder() - c2.getsuitOrder();
		}

		return 0;
	}
}
