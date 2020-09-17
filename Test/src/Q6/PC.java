package Q6;

public class PC extends AllPC{
	
	private double cost = 0;

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
