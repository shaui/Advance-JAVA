package Q6_2;

public class Main5 {

	public static void main(String[] args) {
		Management m = new Management();
		
		
		try {
			if(m.totalSal() > 50000) {
				throw new Exception("Total Salary exceeds limit:" + m.totalSal());
			}
				
		} catch (Exception e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	

	}

}
