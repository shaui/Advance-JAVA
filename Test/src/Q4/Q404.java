package Q4;

import java.util.Scanner;

public class Q404 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int m = 0;
		int n = 0;
		System.out.print("Input m:");
		m = s.nextInt();
		System.out.print("Input n:");
		n = s.nextInt();
		
		while(m != 999 && n != 999) {
			System.out.println("最大公因數為  = " + gcd(m,n) );
			
			System.out.print("Input m:");
			m = s.nextInt();
			if(m == 999) {
				break;
			}
			System.out.print("Input n:");
			n = s.nextInt();
			if(n == 999) {
				break;
			}
		}
	}

	public static int gcd(int m, int n) {
		if(m%n != 0) {
			return gcd(n, m%n);
		}
		else {
			return n;
		}
	}
}
