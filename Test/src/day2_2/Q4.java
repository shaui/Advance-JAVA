package day2_2;

public class Q4 {

	public static void main(String[] args) {
		Management m = new Management();
		String id = "97001";
		
		m.add_worker(id, new Manager());
		System.out.println(id +"ªºµ|«áÁ~¸ê: " + m.afterTax(id));

		
	}

}
