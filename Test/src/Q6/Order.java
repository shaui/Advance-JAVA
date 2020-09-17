package Q6;

import java.util.LinkedList;

public class Order {
	
	LinkedList<AllPC> l = new LinkedList<AllPC>();
	
	public Order() {
		MiniNote m = new MiniNote();
		Note15 n = new Note15();
		PC p = new PC();
		l.add(m);
		l.add(n);
		l.add(p);
	}
	
	public double revenue() {
		double total = 0;
		for(AllPC x : l) {
			total += x.getPrice() ;
		}
		return total;
	}
	
	public double profit() {
		double total = 0;
		for(AllPC x : l) {
			total += ( x.getPrice() - x.getCost() );
		}
		return total;
	}
}
