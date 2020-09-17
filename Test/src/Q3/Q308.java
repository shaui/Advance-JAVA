package Q3;

import java.util.Scanner;

public class Q308 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = 0;
		int total = 0;
		do {
			System.out.print("請輸入消費金額，或輸入-1結束:");
			input = s.nextInt();
			if(input != -1) {
				total += input;
			}
		}while(input != -1);
		System.out.println("電腦周邊總消費"
				+ total);
	}

}
