package Q6_2;

public class Main3 {

	public static void main(String[] args) {
		SalaryWorker s = new SalaryWorker("96001");
		HourlyWorker h = new HourlyWorker("96002");
		Manager m = new Manager("97001");
		
		System.out.print("SalaryWorker�|�B:" + s.getTax() + " ");
		System.out.println("HourlyWorker�|�B:" + h.getTax());
		System.out.print("Manager�|�B:" + m.getTax() + " ");
		System.out.println("�����|�B:" + averSal());


	}
	
	public static double averSal() {
		return Worker.total_tax/Worker.num;
	}

}
