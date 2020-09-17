package day1_even;

import java.util.Scanner;

public class Switch_score {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = 0;
		/*
		for(int i=0; i<4; i++) {
			System.out.println("Input:");
			input = s.nextInt();
			if(90 <= input) {
				System.out.println("Your grade is A");
			}
			else if(80 <= input && input < 90) {
				System.out.println("Your grade is B");
			}
			else if(70 <= input && input < 80) {
				System.out.println("Your grade is C");
			}
			else if(60 <= input && input < 70) {
				System.out.println("Your grade is D");
			}
			else if(60 < input){
				System.out.println("Your grade is F");
			}
		*/
		for(int j=0; j<4; j++) {
			System.out.println("Input:");
			input = s.nextInt();
			switch(input/10) {
				case(10):
				case(9):
					System.out.println("Your grade is A");
					break;
				case(8):
					System.out.println("Your grade is B");
					break;
				case(7):
				case(6):
					System.out.println("Your grade is D");
					break;
				default:
					System.out.println("Your grade is F");
					break;
			}	
		}					
	}
}
