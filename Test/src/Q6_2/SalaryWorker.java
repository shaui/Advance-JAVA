package Q6_2;

public class SalaryWorker extends Worker{
	
	private double year_sal = 0;

	public SalaryWorker(String id) {
		super(id);
		// TODO �۰ʲ��ͪ��غc�l Stub
		year_sal = 180000;
	}
	public double monthPay() {
		return year_sal/12;
	}

}
