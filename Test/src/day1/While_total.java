package day1;

import java.util.Scanner;

public class While_total {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int total = 0;
		System.out.println("請輸入消費金額，或輸入-1結束:");
		int input = s.nextInt();
		
		while(input != -1) {
			total += input;
			System.out.println("請輸入消費金額，或輸入-1結束:");
			input = s.nextInt();
		}
		System.out.println("電腦周邊總消費:" + total);

	}

}
