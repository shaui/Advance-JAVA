package day2;

public class PC extends ALL_Product{
	int cost = 0;
	
	public PC() {
		CPU c = new CPU(2.4);
		HD h = new HD("160G");
		
		cost = c.getCost() + h.getCost();
		
	}
	
	public double getCost() {
		return cost + 500;
	}
	
	public double getPrice() {
		return cost*1.8;
	}
	
}
