package Q5;

import java.util.Scanner;

public class Q502 {

	public static void main(String[] args) {
		// TODO �۰ʲ��ͪ���k Stub
		double total = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("�п�J�ǥͤH��:");
		int num = s.nextInt();
		double[] a = new double[num];
		for(int i=0; i<a.length; i++) {
			System.out.print("�п�J��" + (i+1) + "�Ӿǥͪ����Z:");
			a[i] = s.nextDouble();
			total += a[i];
		}
		System.out.println("�H��:" + a.length );
		System.out.println("�`��:" + total);
		System.out.printf("����:%.6f:",total/a.length);
	}

}
