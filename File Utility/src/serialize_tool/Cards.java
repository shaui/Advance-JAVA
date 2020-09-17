package serialize_tool;

import java.io.Serializable;

public class Cards implements Serializable {
	
	private final String[] suits = {"club","diamond","heart","spade"};
	private String suit;
	private int suitOrder;
	private int point;
	
	public Cards(int suitOrder, int point) {
		this.suitOrder = suitOrder;
		this.point = point;
		suit = suits[suitOrder];
	}
	
	public void setsuitOrder(int s) {
		suitOrder = s;
	}
	
	public int getsuitOrder() {
		return suitOrder;
	}
	
	public void setPoint(int p) {
		point = p;
	}
	
	public int getPoint() {
		return point;
	}
	
	public String getSuit() {
		return suit;
	}
}
