package day2;

public class Main2 {

	public static void main(String[] args) {
		PC p = new PC();
		MultiPC m1 = new MultiPC(2,4);
		MultiPC m2 = new MultiPC(4,8);
		
		System.out.println("PC cost:" + p.getCost() + ",price:" + p.getPrice());
		System.out.println("MultiPC 2CPU, 4HD, " + "cost:" + m1.getCost() + ",price:" + m1.getPrice());
		System.out.println("MultiPC 4CPU, 8HD, " + "cost:" + m2.getCost() + ",price:" + m2.getPrice());
		

	}

}
