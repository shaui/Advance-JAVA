package Q6;

public class MiniNote extends AllPC{
	
	private double cost = 0;
	
	
	public MiniNote(){
		LCD l = new LCD(10);
		CPU c = new CPU(1.66);
		HD h = new HD("120G");
		cost = l.getCost() + c.getCost() + h.getCost();
	}
	
	public double getCost() {
		return cost*1.4;
	}
	
	public double getPrice() {
		return cost*2.0;
	}

}
