package day1;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<2; i++) {
			System.out.println("Input:");
			int a = s.nextInt();
			int b = s.nextInt();
			if(a > b) {
				System.out.println(a + " is larger than " + b);
			}
			else if(b > a){
				System.out.println(b + " is larger than " + a);
			}
			else {
				System.out.println(b + " equal to " + a);
			}
		}
	}

}
