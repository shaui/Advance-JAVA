package day2_2;

public class Q2 {

	public static void main(String[] args) {
		SalaryWorker s = new SalaryWorker();
		HourlyWorker h = new HourlyWorker();
		Manager m = new Manager();
		
		System.out.println("SalaryWorker: " + s.monthPay());
		System.out.println("HourlyWorker: " + h.monthPay());
		System.out.println("Manager: " + m.monthPay());
		
		if(s.monthPay() > h.monthPay()) {
			System.out.println(s.getID() + "較高");
		}
		else {
			System.out.println(h.getID() + "較高");
		}
		
		if(h.monthPay() > m.monthPay()) {
			System.out.println(h.getID() + "較高");
		}
		else {
			System.out.println(m.getID() + "較高");
		}
		
		System.out.println("SalaryWorker稅額: " + s.monthPay()*0.15);
		System.out.println("HourlyWorker稅額: " + h.monthPay()*0.15);
		System.out.println("Manager稅額: " + m.monthPay()*0.15);

	}

}
