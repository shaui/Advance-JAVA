package Q1;

import java.util.Scanner;

public class Q104 {

	public static void main(String[] args) {
		// TODO �۰ʲ��ͪ���k Stub
		Scanner s = new Scanner(System.in);
		System.out.print("�п�J�Ĥ@��x,y�y��:");
		double x1 = s.nextDouble();
		double y1 = s.nextDouble();
		System.out.print("�п�J�ĤG��x,y�y��:");
		double x2 = s.nextDouble();
		double y2 = s.nextDouble();
		System.out.printf("����(%.2f,%.2f)�M(%.2f,%.2f)�������Z���O%.2f",x1,y1,x2,y2,f(x1-x2,y1-y2));
		
	}
	public static double f(double x, double y) {
		return  Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
	}

}
