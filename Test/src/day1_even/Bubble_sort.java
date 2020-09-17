package day1_even;

public class Bubble_sort {

	public static void main(String[] args) {
		int[] bubble = {2,3,5,4,6,7,1,9};
		for(int i=0; i<bubble.length-1; i++) {
			for(int x:bubble) {
				System.out.print(x + " ");
			}
			System.out.println();
			for(int j=0; j<bubble.length-1; j++) {
				if(bubble[j+1] < bubble[j]) {
					int temp = bubble[j];
					
					bubble[j] = bubble[j+1];
					bubble[j+1] = temp;
				}
			}
			
		}
		

	}

}
