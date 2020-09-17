package Q6;

public class Main3 {

	public static void main(String[] args) {
		AllPC a1 = new PC();
		AllPC a2 = new Note15();
			
		if(a1.isExpensive(a1, a2)) {
			System.out.println("PC is more expensive than Note15");
		}
		else{
			System.out.println("Note15 is more expensive than PC");
		}

	}

}
