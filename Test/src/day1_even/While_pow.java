package day1_even;

import java.util.Scanner;

public class While_pow {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Input:");
		int a = s.nextInt();
		int b = s.nextInt();
		while(a != 999) {
			System.out.println(pow(a,b));
			System.out.println("Input:");
			a = s.nextInt();
			b = s.nextInt();
		}
	}
	
	public static int pow(int a, int b) {
		int result = 1;
		while(b > 0) {
			result = a*result;
			b--;
		}
		return result;
		
	}
	
	

}
