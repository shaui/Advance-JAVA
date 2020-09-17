package day1;

public class Cal {

	public static void main(String[] args) {
		double x;
		x = -3.2;
		System.out.printf("f(%4.1f) = %.4f\n",x,f(x));
		x = -2.1;
		System.out.printf("f(%4.1f) = %.4f\n",x,f(x));
		x = 0;
		System.out.printf("f(%4.1f) = %.4f\n",x,f(x));
		x = 2.1;
		System.out.printf("f(%4.1f) = %.4f",x,f(x));

	}
	public static double f(double a) {
		double relsult = 3*Math.pow(a,3) + 2*a - 1;
		return relsult;
	}

}
