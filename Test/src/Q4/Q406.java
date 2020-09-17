package Q4;

import java.util.Scanner;

public class Q406 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Scanner s = new Scanner(System.in);
		String input = "";
		System.out.print("Input a string:");
		input = s.nextLine();
		System.out.println(input + " hsa " + calA(input) + " As");

		
	}
	
	public static int calA(String s) {
		
		if(s.length() != 0) {
			if(s.charAt(0) == 'A') {
				return 1 + calA(s.substring(1));
			}
			else {
				return calA(s.substring(1));
			}
		}
		else {
			return 0;
		}
		
		
	}

}
