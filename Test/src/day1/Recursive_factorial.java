package day1;

import java.util.Scanner;

public class Recursive_factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Input n (0 <= n <= 16)");
		
		int input = s.nextInt();
		while(input != 999) {
			System.out.println("6ªº¶¥¼h(§ÀºÝ»¼°j) = " + recursive(input));
			System.out.println("6ªº¶¥¼h(°j°é) = " + loop(input));
			System.out.println("Input n (0 <= n <= 16)");
			input = s.nextInt();
			
		}
	}
	
	public static int recursive(int a) {
		
		if(a > 1) {
			return a*recursive(a-1);
		}
		else {
			return a;
		}
		/*
		public static int facRec(int a, int b){
			if(a == 1){
				return b;
			}
			else{
				return facRec(a-1, a*b);
			}
		 }
		 */
	}
	
	public static int loop(int a) {
		int total = 1;
		for(int i=1; i<=a; i++) {
			total *= i;
		}
		
		return total;
	}

}
