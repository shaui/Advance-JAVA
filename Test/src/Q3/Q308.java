package Q3;

import java.util.Scanner;

public class Q308 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = 0;
		int total = 0;
		do {
			System.out.print("�п�J���O���B�A�ο�J-1����:");
			input = s.nextInt();
			if(input != -1) {
				total += input;
			}
		}while(input != -1);
		System.out.println("�q���P���`���O"
				+ total);
	}

}
