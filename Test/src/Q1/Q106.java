package Q1;

public class Q106 {

	public static void main(String[] args) {
		System.out.printf("f(-3.2) = %.4f\n",f(-3.2));
		System.out.printf("f(-2.1) = %.4f\n",f(-2.1));
		System.out.printf("f(0) = %.4f\n",f(0));
		System.out.printf("f(2.1) = %.4f\n",f(2.1));

	}
	
	public static double f(double x) {
		x = 3*(Math.pow(x, 3)) + 2*x -1;
		return x;
	}

}
