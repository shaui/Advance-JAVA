package day2;

public class MultiPC extends ALL_Product{
	int cost = 0;
	
	public MultiPC(int c_num, int h_num) {
		CPU c = new CPU(2.4);
		HD h = new HD("160G");
		
		cost = c.getCost()*c_num + h.getCost()*h_num;
		
	}
	
	public double getCost() {
		return cost*1.2;
	}
	
	public double getPrice() {
		return cost*1.8;
	}
	
}
