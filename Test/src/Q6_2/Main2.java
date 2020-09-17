package Q6_2;

public class Main2 {

	public static void main(String[] args) {
		SalaryWorker s = new SalaryWorker("96001");
		HourlyWorker h = new HourlyWorker("96002");
		Manager m = new Manager("97001");
		
		System.out.println("SalaryWorker: " + s.monthPay());
		System.out.println("HourlyWorker: " + h.monthPay());
		System.out.println("Manager: " + m.monthPay());
		
		System.out.println(s.compareSal(s, h));
		System.out.println(s.compareSal(h, m));
		
		System.out.println("SalaryWorkerµ|²v:" + s.getTax());
		System.out.println("HourlyWorkerµ|²v:" + h.getTax());
		System.out.println("Managerµ|²v:" + m.getTax());

	}

}
