package Q1;

import java.util.Scanner;

public class Q102 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Scanner s = new Scanner(System.in);
		System.out.print("Input:");
		double input = s.nextDouble();
		System.out.printf("%.6f kg=%.6f ponds",input,f(input));
		
		
	}
	
	public static double f(double a) {
		return a*2.20462;
	}

}
