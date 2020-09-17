package day1;

import java.util.Scanner;

public class Recursive_gcd {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Input m:");
		int m = s.nextInt();
		System.out.println("Input n:");
		int n = s.nextInt();
		System.out.println("最大公因數為:" + gcd(m,n));
		
		

	}
	
	public static int gcd(int a, int b) {
		/*
		if(a > b) {
			if(a%b != 0) {
				return gcd(a%b,b);
			}
			else {
				return b;
			}
		}
		else {
			if(b%a != 0) {
				return gcd(b%a,a);
			}
			else {
				return a;
			}
		}
		*/
		if(a%b != 0) {
			return gcd(b,a%b);
		}
		else {
			return b;
		}
	}
	
	public static int gcd2(int m, int n) {
		if(n == 0) {
			return m;
		}
		else {
			/*
			 int tem = n;
			 n = m%n;
			 m = tem;
			 return(m,n);
			 */
			return gcd2(n, m%n);
		}
	}

}
