package Q3;

import java.util.Scanner;

public class Q304 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter meal dollars -1 too stop:");
		double total = 0;
		int count = 0;
		
		double input = s.nextDouble();
		total += input;
		count++;
		while(input != -1) {
			System.out.print("Please enter meal dollars -1 too stop:");
			input = s.nextDouble();
			if(input != -1) {
				total += input;
				count++;
			}
		}
		if(input != -1) {
			System.out.printf("餐點總費用:%.1f\n", total);
			System.out.printf("%s道餐點平均費用為: %.2f", count , total/count);
		}
		
		

	}

}
