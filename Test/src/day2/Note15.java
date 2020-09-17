package day2;

public class Note15 extends ALL_Product{

	int cost = 0;
	
	public Note15(){
		LCD l = new LCD(15);
		CPU c = new CPU(2.2);
		HD h = new HD("160G");
		
		cost = l.getCost() + c.getCost() + h.getCost();	
	}
	
	public double getCost() {
		return cost*1.4;
	}
	
	public double getPrice() {
		return cost*2;
	}
}
