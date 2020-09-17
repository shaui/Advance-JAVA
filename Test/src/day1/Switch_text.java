package day1;

import java.util.Scanner;

public class Switch_text {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input a character:");
		
		
		
		for(int i=0; i<5; i++) {
			String input = s.next();
			char head = input.charAt(0);
			switch(head) {
			case 'a':
			case 'b':
				System.out.println("You entered a or b");
				break;
			case 'x':
				System.out.println("You entered x");
				break;
			case 'y':
				System.out.println("You entered y");
				break;
			default: 
                System.out.println("You entered something else"); 
				break;
			}
		}
			

	}

}
