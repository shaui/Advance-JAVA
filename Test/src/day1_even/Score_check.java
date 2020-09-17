package day1_even;

import java.util.Scanner;

public class Score_check {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<4; i++) {
			System.out.println("Input Chinese score");
			int x = s.nextInt();
			
			System.out.println("Input English score");
			int y = s.nextInt();
			
			System.out.println("Input Math score");
			int z = s.nextInt();
			
			if(x < 60) {
				System.out.println("Chinese failed");
			}
			if(y < 60) {
				System.out.println("English failed");
			}
			if(z < 60) {
				System.out.println("Math failed");
			}
			if(x >= 60 && y >= 60 && z >= 60) {
				System.out.println("All pass");
			}
			
		}
		


	}

}
