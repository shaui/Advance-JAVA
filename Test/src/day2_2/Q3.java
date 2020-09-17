package day2_2;

public class Q3 {

	public static void main(String[] args) {
		SalaryWorker s = new SalaryWorker();
		HourlyWorker h = new HourlyWorker();
		Manager m = new Manager();
		
		s.pay_tax();
		System.out.println("SalaryWorker: " + s.monthPay()*0.15);
		h.pay_tax();
		System.out.println("HourlyWorker: " + h.monthPay()*0.15);
		m.pay_tax();
		System.out.println("Manager: " + m.monthPay()*0.15);
		
		System.out.println("¥­§¡µ|°È:" + Work.total_tax/Work.worker_num);
		
		

	}

}
