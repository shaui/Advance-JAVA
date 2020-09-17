package day2;

public class Main5 {

	public static void main(String[] args) {
		Order o = new Order();
		o.in(new MiniNote());
		o.in(new Note15());
		o.in(new PC());
		
		double profit = o.revenue() - o.expense();
		
		try {
			if(profit > 20000) {
				throw new Exception("The order exceeds 20000:" + profit);
			}	
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		

	}

}
