package Q5;

public class Q508 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		boolean flag = true;
		int[] a = {2,5,8,9,1,0,10,6,7,11};
		for(int i=0; i<a.length - 1; i++) {
			if(flag == true) {
				flag = false;
				for(int j=0; j<a.length - 1; j++) {
					if(a[j] > a[j+1]) {
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
						flag = true;
					}
				}
				if(flag == true) {
					for(int k=0; k<a.length; k++) {
						System.out.print(a[k] + " ");
					}
					System.out.println();
				}
			}
		}
	}

}
