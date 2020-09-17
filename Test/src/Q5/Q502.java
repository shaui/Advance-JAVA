package Q5;

import java.util.Scanner;

public class Q502 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		double total = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("請輸入學生人數:");
		int num = s.nextInt();
		double[] a = new double[num];
		for(int i=0; i<a.length; i++) {
			System.out.print("請輸入第" + (i+1) + "個學生的成績:");
			a[i] = s.nextDouble();
			total += a[i];
		}
		System.out.println("人數:" + a.length );
		System.out.println("總分:" + total);
		System.out.printf("平均:%.6f:",total/a.length);
	}

}
