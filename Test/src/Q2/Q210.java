package Q2;

import java.util.Scanner;

public class Q210 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			System.out.println("Input a charcter:");
			String input = s.nextLine();
			switch(input) {
				case "a":
				case "b":
					System.out.println("You entered a or b");
					break;
				case "x":
					System.out.println("You entered x");
					break;
				case "y":
					System.out.println("You entered y");
					break;
				default :
					System.out.println("You entered something else");
					break;
			}
		}
	}

}
