package day1_even;

import java.util.Scanner;

public class Cal_dis {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("�п�J�Ĥ@�ժ�x�y�ЩMy�y��:");
		double x1 = s.nextDouble();
		double y1 = s.nextDouble();
		System.out.println("�п�J�ĤG�ժ�x�y�ЩMy�y��:");
		double x2 = s.nextDouble();
		double y2 = s.nextDouble();
		System.out.printf("%.2f", cal(x1-x2,y1-y2));
		

	}
	public static double cal(double a, double b) {
		double result = 0;
		result = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
		
		return result;
	}

}
