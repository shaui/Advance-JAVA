package day2;

public class Main3 {

	public static void main(String[] args) {
		AllPC a = new AllPC();
		
		Note15 n = new Note15();
		PC p = new PC();
		
		if(a.isExpensive(n, p)) {
			System.out.println("Note15 is more expensive than PC");
		}
		else {
			System.out.println("PC is more expensive than Note15");
		}
		
		/*
		if(1 == 1.0) {
			System.out.println(123);
		}
		*/
	}

}
