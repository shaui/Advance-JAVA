package day2_2;

public class HourlyWorker extends Work{

	private double workTime = 160;
	
	public HourlyWorker() {
		id = "96002";
		sal = 100;
	}
	
	public double monthPay() {
		return sal*workTime;
	}
	
	
	
}
