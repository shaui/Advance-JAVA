package Q5;

import java.util.Scanner;

public class Q510 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] binary = {5,9,13,15,17,19,25,30,45};
		System.out.print("請輸入要找尋的資料:");
		int input = s.nextInt();
		bi(binary,input);
		
	}
	
	public static void bi(int[] b, int data) {
		int count = 0;
		int left = 0;
		int right = b.length-1;
		int middle = (left+right)/2;
		count++;
		System.out.printf("尋找區間:%d(%d)..%d(%d),中間:%d(%d)\n",left,b[left],right,b[right],middle,b[middle]);
		
		while(b[middle] != data) {
			if(data < b[middle]) {
				right = middle - 1;
				middle = (left+right)/2;
			}
			else if(data > b[middle]) {
				left = middle + 1;
				middle = (left+right)/2;
			}
			if(left <= right) {
				count++;
				System.out.printf("尋找區間:%d(%d)..%d(%d),中間:%d(%d)\n",left,b[left],right,b[right],middle,b[middle]);
			}
			else {
				break;
			}
		}
		System.out.println("經過" + count + "次尋找");
		if(b[middle] == data) {
			System.out.println("您要的資料在陣列中第" + middle + "個位置");
		}
		else {
			System.out.println(data + "不再陣列中");
		}
	}
	
}
