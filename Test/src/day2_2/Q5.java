package day2_2;

public class Q5 {

	public static void main(String[] args) {
		Management m = new Management();
		m.add_worker("96001", new SalaryWorker());
		m.add_worker("96002", new HourlyWorker());
		m.add_worker("97001", new Manager());
		
		try {
			if(m.total_month_sal() > 50000) {
				m.check();
			}
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			System.out.println("Total salary exceeds limit:" + m.total_month_sal());
		}
	}

}
