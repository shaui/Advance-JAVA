package day1_even;

import java.util.Scanner;

public class Even_add {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sum = 0;
		System.out.println("叫块n( n > 0 ,案计):");
		int a = s.nextInt();
		while(a%2 != 0) {
			System.out.println("叫块n( n > 0 ,案计):");
			a = s.nextInt();
		}
		
		int head = 2;
		do {
			if(head < a) {
				System.out.print(head + "+");
			}
			else {
				System.out.print(a + "=");
			}
			sum += head;
			head += 2;
			
		}while(head <= a);
		System.out.print(sum);
		

	}

}
