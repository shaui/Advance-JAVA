package Q6;

public class Note15 extends AllPC{

	private double cost = 0;
	
	
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
		return cost*2.0;
	}
}
