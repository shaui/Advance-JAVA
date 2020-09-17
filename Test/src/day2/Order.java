package day2;

import java.util.LinkedList;

public class Order {
	
	LinkedList<ALL_Product> l;
	
	public Order() {
		l = new LinkedList<ALL_Product>();
	}
	
	public void in(ALL_Product p) {
		l.add(p);
	}
	
	public double revenue() {
		double total = 0;
		
		int length = l.size();
		for(int i=0; i<length; i++) {
			total += l.get(i).getPrice();
		}
		return total;
	}
	
	public double expense() {
		double total = 0;
		int length = l.size();
		for(int i=0; i<length; i++) {
			total += l.get(i).getCost();
		}
		return total;
	}
}
