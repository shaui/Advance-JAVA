package day1_even;

import java.util.Scanner;

public class Divisible {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input:");
		int x = s.nextInt();
		if(x%5 == 0 && x%9 == 0) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}
