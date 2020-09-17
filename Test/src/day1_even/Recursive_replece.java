package day1_even;

import java.util.Scanner;

public class Recursive_replece {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input a string");
		String str = s.nextLine();
		System.out.println("Input a character");
		String rep1 = s.nextLine();
		System.out.println("Input another character");
		String rep2 = s.nextLine();
		//System.out.println(recur_replace(str,0,rep1,rep2));
		
		System.out.println(tt(str,rep1,rep2,0));
		
	}
	
	public static String tt(String s1, String s2, String s3, int index) {
		if(index + s2.length() < s1.length()) {
			if(s1.substring(index, index + s2.length()).equals(s2)) {
				
				s1 = s1.replaceFirst(s2, s3);
				index++;
				return tt(s1,s2,s3,index);
			}
			else {
				index++;
				return tt(s1,s2,s3,index);
			}
		}
		return s1;
	}
	
	public static String recur_replace(String s1, int index, String s2, String s3) {
		if(index < s1.length()) {
			
			if( s1.substring(index,index+1).equals(s2)) {			
				index++;
				
				return s1.replace(s2, s3);
				/*
				s1 = s1.replaceFirst(s2, s3);
				return recur_replace(s1,index,s2,s3);
				*/
			}
			else {
				index++;
				return recur_replace(s1,index,s2,s3);
			}			
		}
		
		return s1;
		
	}

}
