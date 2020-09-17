package Q6;

public class MultiPC extends AllPC{

	private double cost = 0;

	public MultiPC(int a, int b) {
		CPU c = new CPU(2.4);
		HD h = new HD("160G");
		cost = a*c.getCost() + b*h.getCost();
	}
	
	public double getCost() {
		return cost*1.2;
	}
	
	public double getPrice() {
		return cost*1.8;
	}
}
