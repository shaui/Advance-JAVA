package day1_even;

import java.util.Scanner;

public class Recursive_inverse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for(int i=0; i<2; i++) {
			System.out.println("Input a string: ");
			String str = s.nextLine();
			
			System.out.println(inverse(str,str.length()-1,""));
		}

	}
	
	public static String inverse(String s,int index, String s2) {
		if(index >= 0) {
			s2 += s.charAt(index);
			index--;
			return inverse(s,index,s2);
		}
		else {
			return s2;
		}
		
		
		
	}

}
