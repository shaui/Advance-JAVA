package Q6_2;

import java.util.HashMap;

public class Management {

	HashMap<String,Worker> h_map = new HashMap<String, Worker>();
	public Management() {
		h_map.put("96001", new SalaryWorker("96001"));
		h_map.put("96002", new HourlyWorker("96002"));
		h_map.put("97001", new Manager("97001"));
	}
	
	public double afterTax(String id) {
		return h_map.get(id).monthPay() -  h_map.get(id).getTax();
	}
	
	public double totalSal() {
		double total = 0;
		for(Worker w : h_map.values()) {
			total += w.monthPay();
		}
		return total;
	}
}
