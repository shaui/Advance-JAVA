package day1;

import java.util.Scanner;

public class Do_while_total {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double total = 0;
		int count = 0;
		double input = 0.0;
		do {
			System.out.println("Please enter meal dollars or enter -1 to stop:");
			input = s.nextDouble();
			if(input != -1) {
				total += input;
				count++;
			}
		}while(input != -1);
		System.out.printf("�\�I�`�O��:%.1f\n" , total);
		System.out.printf(" %d�D�\�I�����O�ά�: %.2f", count, total/count);
		
		
	}

}
