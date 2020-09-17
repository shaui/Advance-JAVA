package day2_2;

public class Q1 {

	public static void main(String[] args) {
		SalaryWorker s = new SalaryWorker();
		HourlyWorker h = new HourlyWorker();
		Manager m = new Manager();
		
		System.out.println("SalaryWorker: " + s.monthPay());
		System.out.println("HourlyWorker: " + h.monthPay());
		System.out.println("Manager: " + m.monthPay());
		
	}

}
