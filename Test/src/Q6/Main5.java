package Q6;

public class Main5 {

	public static void main(String[] args) {
		Order o = new Order();
		
			try {
				if(o.profit() > 20000) {
					throw new Exception("This order exceeds 20000:" + o.profit() );
				}
			} catch (Exception e) {
				// TODO �۰ʲ��ͪ� catch �϶�
				e.printStackTrace();
			}
		


	}

}
