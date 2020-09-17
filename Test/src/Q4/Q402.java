package Q4;

import java.util.Scanner;

public class Q402 {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Input n (0 <= n <= 16):");
		int input = s.nextInt();
		while(input != 999) {
			System.out.println("6ªº¶¥¼h(§ÀºÝ»¼°j) = " + recursive(input));
			System.out.println("6ªº¶¥¼h(°j°é) = " + loop(input));
			System.out.print("Input n (0 <= n <= 16):");
			input = s.nextInt();
		}
	}

	
	public static int loop(int x) {
		int total = 1;
		for(int i=1; i<=x; i++) {
			total = i*total;
		}
		
		return total;
	}
	
	public static int recursive(int x) {
		
		if(x != 1) {
			return x*recursive(x-1);
		}
		else {
			return 1;
		}
		
			
	}
}
