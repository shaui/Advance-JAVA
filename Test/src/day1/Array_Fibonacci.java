package day1;

public class Array_Fibonacci {

	public static void main(String[] args) {
		int[] fib_array = new int[10];
		fib_array[0] = 0;
		fib_array[1] = 1;
		fib_array = fib(fib_array);
		for(int x: fib_array) {
			System.out.println(x);
		}
		System.out.println("---");
		int[] fib2 = new int[10];
		fib2[0] = 0;
		fib2[1] = 1;
		fib2 = revursive_fib(fib2,2);
		for(int x: fib2) {
			System.out.println(x);
		}
		
	}

	public static int[] fib(int[] a) {
		
		for(int i=2; i<a.length; i++) {
			a[i] = a[i-1] + a[i-2];
		}
		return a;
	}
	
	public static int[] revursive_fib(int[] a, int b) {
		
		if(b < a.length) {
			a[b] = a[b-1] + a[b-2];
			b++;
			return revursive_fib(a,b);
		}
		else {
			return a;
		}
		
		
		
	}
}
