package day2;

public class CPU {
	
	private int cost = 0;
	public CPU(double size){
		if(size == 1.66) {
			cost = 6000;
		}
		else if(size == 2.2) {
			cost = 8000;
		}
		else if(size == 2.4){
			cost = 11000;
		}
	}
	
	public int getCost() {
		return cost;
	}
}
