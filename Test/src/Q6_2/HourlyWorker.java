package Q6_2;

public class HourlyWorker extends Worker{
	
	private double hour_sal = 0;

	public HourlyWorker(String id) {
		super(id);
		// TODO �۰ʲ��ͪ��غc�l Stub
		
		hour_sal = 100;
	}
	
	public double monthPay() {
		return 100*160;
	}

}
