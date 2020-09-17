package day2_2;

public abstract class Work {

	public static double worker_num = 0;
	public static double total_tax = 0;
	String id = "";
	double sal = 0; 
	
	public Work() {
		
	}

	public abstract double monthPay();


	public String getID() {
		return id;
	}
	public void pay_tax() {
		worker_num += 1;
		total_tax += monthPay()*0.15;
	}
}
