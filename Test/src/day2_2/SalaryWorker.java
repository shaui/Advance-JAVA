package day2_2;

public class SalaryWorker extends Work{
	
	public SalaryWorker() {
		id = "96001";
		sal = 180000;
	}
	
	public double monthPay() {
		return sal/12;
	}

	
	
}
