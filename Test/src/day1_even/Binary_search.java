package day1_even;

import java.util.Scanner;

public class Binary_search {

	public static void main(String[] args) {
		int[] binary = {5,9,13,15,17,19,25,30,45};
		Scanner s = new Scanner(System.in);
		int input = 0;
		while(input != -1) {
			System.out.println("請輸入要尋找的資料");
			input = s.nextInt();
			bi_Search(binary,input);
		}
	}
	
	public static void bi_Search(int[] a, int target) {
		int left = 0;
		int right = a.length-1;
		int index = (left + right)/2;
		int count = 1;
		System.out.println("尋找區間" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",中間" + index + "(" + a[index] + ")");
		
		while(a[index] != target && left <= right) {
			if(target < a[index]) {
				right = index-1;
				index = (left + right)/2;
			}
			else if(target > a[index]) {
				left = index+1;
				index = (left + right)/2;
			}
			//是否超出範圍
			if(left <= right) {
				count++;
				System.out.println("尋找區間" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",中間" + index + "(" + a[index] + ")");
			}
		}
		if(left > right) {
			System.out.println("歷經" + count + "次尋找");
			System.out.println(target + " 不再陣列中");
		}
		else if(target == a[index]) {
			System.out.println("歷經" + count + "次尋找");
			System.out.println("您的資料位於陣列中的第" + index + "個位置");
		}
		
		/*
		while(target != a[index]) {
			if(target < a[index]) {
				right = index - 1;
				index = (left + right)/2;
				System.out.println("尋找區間" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",中間" + index + "(" + a[index] + ")");
			}
			else if(target > a[index]) {
				left = index + 1;
				index = (left + right)/2;
				System.out.println("尋找區間" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",中間" + index + "(" + a[index] + ")");
			}
			count++;
			//因為left > right 代表不用搜尋了、 left = right 代表這是最後一次搜尋，下次left會超出範圍
			//target != a[index]一定要設定，不然成功找到也會印出失敗訊息
			if(left >= right && target != a[index]) { 
				System.out.println("歷經" + count + "次尋找");
				System.out.println(target + " 不再陣列中");
				break;
			}
		}
		if(target == a[index]){
			System.out.println("歷經" + count + "次尋找");
			System.out.println("您的資料位於陣列中的第" + index + "個位置");
		}
		*/
		
		
		
		
	}

}
