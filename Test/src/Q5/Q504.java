package Q5;

public class Q504 {

	public static void main(String[] args) {
		int[] f = new int[10];
		f[0] = 0;
		f[1] = 1;
		ff(f);
		for(int i=0; i<f.length; i++) {
			System.out.println(f[i]);
		}
		

	}
	
	public static void ff(int[] a) {
		for(int i=2; i<a.length; i++) {
			a[i] = a[i-1] + a[i-2];
		}
	}
	
	public static int[] r_ff(int[] a, int b) {
		if(b != a.length) {
			a[b] = a[b-1] + a[b-2];
			return r_ff(a, b+1);
		}
		else {
			return a;
		}
		
		
	}

}
