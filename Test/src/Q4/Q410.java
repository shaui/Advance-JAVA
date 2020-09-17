package Q4;

import java.util.Scanner;

public class Q410 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Scanner s = new Scanner(System.in);
		System.out.print("Input a string:");
		String input = s.nextLine();
		System.out.print("Input a character:");
		char a = s.nextLine().charAt(0);
		System.out.print("Input a character");
		char b = s.nextLine().charAt(0);
		System.out.print(change(input,a,b));
	}
	
	public static String change(String s, char a, char b) {
		if(s.length() != 0) {
			if(s.charAt(0) == a) {
				return b + change(s.substring(1),a,b);
			}
			else {
				return s.charAt(0) + change(s.substring(1),a,b);
			}
		}
		else {
			return "";
		}
		
	}

}
