package day1;

import java.util.Scanner;

public class While_total {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int total = 0;
		System.out.println("�п�J���O���B�A�ο�J-1����:");
		int input = s.nextInt();
		
		while(input != -1) {
			total += input;
			System.out.println("�п�J���O���B�A�ο�J-1����:");
			input = s.nextInt();
		}
		System.out.println("�q���P���`���O:" + total);

	}

}
