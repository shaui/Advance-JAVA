package day1_even;

import java.util.Scanner;

public class Binary_search {

	public static void main(String[] args) {
		int[] binary = {5,9,13,15,17,19,25,30,45};
		Scanner s = new Scanner(System.in);
		int input = 0;
		while(input != -1) {
			System.out.println("�п�J�n�M�䪺���");
			input = s.nextInt();
			bi_Search(binary,input);
		}
	}
	
	public static void bi_Search(int[] a, int target) {
		int left = 0;
		int right = a.length-1;
		int index = (left + right)/2;
		int count = 1;
		System.out.println("�M��϶�" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",����" + index + "(" + a[index] + ")");
		
		while(a[index] != target && left <= right) {
			if(target < a[index]) {
				right = index-1;
				index = (left + right)/2;
			}
			else if(target > a[index]) {
				left = index+1;
				index = (left + right)/2;
			}
			//�O�_�W�X�d��
			if(left <= right) {
				count++;
				System.out.println("�M��϶�" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",����" + index + "(" + a[index] + ")");
			}
		}
		if(left > right) {
			System.out.println("���g" + count + "���M��");
			System.out.println(target + " ���A�}�C��");
		}
		else if(target == a[index]) {
			System.out.println("���g" + count + "���M��");
			System.out.println("�z����Ʀ��}�C������" + index + "�Ӧ�m");
		}
		
		/*
		while(target != a[index]) {
			if(target < a[index]) {
				right = index - 1;
				index = (left + right)/2;
				System.out.println("�M��϶�" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",����" + index + "(" + a[index] + ")");
			}
			else if(target > a[index]) {
				left = index + 1;
				index = (left + right)/2;
				System.out.println("�M��϶�" + left + "(" +a[left] + ")" + ".." + right + "(" + a[right] + ")" + ",����" + index + "(" + a[index] + ")");
			}
			count++;
			//�]��left > right �N���ηj�M�F�B left = right �N��o�O�̫�@���j�M�A�U��left�|�W�X�d��
			//target != a[index]�@�w�n�]�w�A���M���\���]�|�L�X���ѰT��
			if(left >= right && target != a[index]) { 
				System.out.println("���g" + count + "���M��");
				System.out.println(target + " ���A�}�C��");
				break;
			}
		}
		if(target == a[index]){
			System.out.println("���g" + count + "���M��");
			System.out.println("�z����Ʀ��}�C������" + index + "�Ӧ�m");
		}
		*/
		
		
		
		
	}

}
