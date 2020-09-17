package Q6;

public class LCD extends Unit{

	
	public LCD(int size) {
		if(size == 10) {
			cost = 2000;
		}
		else if(size == 15) {
			cost = 2500;
		}
		else if(size == 17) {
			cost = 3000;
		}
	}
	
	public double getCost() {
		return cost;
	}
	
	
}
