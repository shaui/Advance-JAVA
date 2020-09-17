package day2_2;

public class Manager extends SalaryWorker{

	private int bonus = 0;
	
	public Manager() {
		id = "97001";
		sal = 240000;
		bonus = 5000;
	}
	
	public double monthPay() {
		return sal/12 + bonus;
	}
	
	
}
