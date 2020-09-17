package Q6_2;

public class Main3 {

	public static void main(String[] args) {
		SalaryWorker s = new SalaryWorker("96001");
		HourlyWorker h = new HourlyWorker("96002");
		Manager m = new Manager("97001");
		
		System.out.print("SalaryWorkerµ|ÃB:" + s.getTax() + " ");
		System.out.println("HourlyWorkerµ|ÃB:" + h.getTax());
		System.out.print("Managerµ|ÃB:" + m.getTax() + " ");
		System.out.println("¥­§¡µ|ÃB:" + averSal());


	}
	
	public static double averSal() {
		return Worker.total_tax/Worker.num;
	}

}
