package Q6;

public class CPU extends Unit{


	public CPU(double speed) {
		if(speed == 1.66) {
			cost = 6000;
		}
		else if(speed == 2.2) {
			cost = 8000;
		}
		else if(speed == 2.4) {
			cost = 11000;
		}
	}
	
	public double getCost() {
		return cost;
	}
}
