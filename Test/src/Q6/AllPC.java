package Q6;

public abstract class AllPC {
	
	public abstract double getPrice();
	public abstract double getCost();

	public boolean isExpensive(AllPC p1, AllPC p2) {
		return p1.getPrice() > p2.getPrice();
	}
}
