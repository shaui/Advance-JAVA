package Q1;

import java.util.Scanner;

public class Q104 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Scanner s = new Scanner(System.in);
		System.out.print("請輸入第一組x,y座標:");
		double x1 = s.nextDouble();
		double y1 = s.nextDouble();
		System.out.print("請輸入第二組x,y座標:");
		double x2 = s.nextDouble();
		double y2 = s.nextDouble();
		System.out.printf("介於(%.2f,%.2f)和(%.2f,%.2f)之間的距離是%.2f",x1,y1,x2,y2,f(x1-x2,y1-y2));
		
	}
	public static double f(double x, double y) {
		return  Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
	}

}
