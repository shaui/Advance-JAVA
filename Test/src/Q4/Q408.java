package Q4;

import java.util.Scanner;

public class Q408 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Scanner s = new Scanner(System.in);
		String input = "";
		System.out.print("Input a string:");
		input = s.nextLine();
		System.out.println(rev(input));
		
	}
	
	public static String rev(String s) {
		
		if(s.length() != 0) {
			return s.substring(s.length()-1) + rev (s.substring(0, s.length()-1) );
		}
		else {
			return "";
		}
		
		
	}

}
