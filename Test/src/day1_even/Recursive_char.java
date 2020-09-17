package day1_even;

import java.util.Scanner;

public class Recursive_char {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		
		for(int i=0; i<2; i++) {
			System.out.println("Input a string: ");
			String str = s.nextLine();
			System.out.println(str + " has " + recursive_char(str,0,0) + " As");
		}
		
	}
	
	public static int recursive_char(String s, int index, int num) {
		
		if(index < s.length()) {
			if(s.charAt(index) == 'A') {
				num += 1;
				index++;
				return recursive_char(s,index,num);
			}
			else {
				index++;
				return recursive_char(s,index,num);
			}
		}
		
		return num;
		
		
		
	}

}
