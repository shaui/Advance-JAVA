package Q6_2;

public class Manager extends SalaryWorker{
	
	private double year_sal = 0;

	public Manager(String id) {
		super(id);
		// TODO �۰ʲ��ͪ��غc�l Stub
		year_sal = 240000;
		
	}
	
	public double monthPay() {
		return year_sal/12 + 5000;
	}


}
