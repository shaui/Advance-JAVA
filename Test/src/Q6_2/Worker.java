package Q6_2;

public abstract class Worker {
	
	private String id = "";
	public static int num = 0;
	public static double total_tax = 0;
	
	public Worker(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public abstract double monthPay();
	
	public double getTax() {
		num++;
		total_tax += monthPay()*0.15;
		return monthPay()*0.15;
	}
	
	
	public String compareSal(Worker w1, Worker w2) {
		if(w1.monthPay() > w2.monthPay()) {
			return w1.getID() + "較高";
		}
		else {
			return w2.getID() + "較高";
		}
		
	}
}
