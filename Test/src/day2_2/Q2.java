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
			System.out.println(s.getID() + "����");
		}
		else {
			System.out.println(h.getID() + "����");
		}
		
		if(h.monthPay() > m.monthPay()) {
			System.out.println(h.getID() + "����");
		}
		else {
			System.out.println(m.getID() + "����");
		}
		
		System.out.println("SalaryWorker�|�B: " + s.monthPay()*0.15);
		System.out.println("HourlyWorker�|�B: " + h.monthPay()*0.15);
		System.out.println("Manager�|�B: " + m.monthPay()*0.15);

	}

}
