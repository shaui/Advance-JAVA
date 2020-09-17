package day2;

public class Main4 {

	public static void main(String[] args) {
		Order o = new Order();
		o.in(new MiniNote());
		o.in(new Note15());
		o.in(new PC());
		
		System.out.println(o.revenue());
	}

}
