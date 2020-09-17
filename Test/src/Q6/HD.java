package Q6;

public class HD extends Unit{

	public HD(String size) {
		if(size == "120G") {
			cost = 2400;
		}
		else if(size == "160G") {
			cost = 2800;
		}
	}
	
	public double getCost() {
		return cost;
	}
}
