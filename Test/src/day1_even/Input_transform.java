package day1_even;

import java.util.Scanner;

public class Input_transform {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please input:");
		double input = s.nextDouble();
		System.out.printf("%.6f kg = %.6f ponds", input, transPonds(input));

	}
	
	public static double transPonds(double d) {
		
		d = d*2.20462;
		return d;
	}

}
