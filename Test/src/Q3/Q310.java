package Q3;

import java.util.Scanner;

public class Q310 {

	public static void main(String[] args) {
		// TODO �۰ʲ��ͪ���k Stub
		int n = 0;
		int index = 0;
		int total = 0;
		Scanner s = new Scanner(System.in);
		do {
			System.out.print("�п�Jn����(n > 0,�B������):");
			n = s.nextInt();
			if(n%2 == 0) {
				while(index <= n) {
					if(index == n) {
						System.out.print(index + "=" + total);
						break;
					}
					else {
						System.out.print(index + "+");
						index += 2;
						total += index;
					}			
				}	
			}
		}while(n > 0 && n%2 != 0);
		
	}

}
