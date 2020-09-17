package Q1;

public class Q108 {

	public static void main(String[] args) {
		System.out.println("Add two integer:2,3");
		System.out.println("Add two doubles:5.2,4.3");
		System.out.println("Add two strings:I love ,Java!!");
		System.out.println(add(2,3) + " " + add(5.2,4.3) + " " + add("I love ","Java!!"));

	}

	public static int add(int a, int b) {
		return a+b;
	}
	
	public static double add(double a, double b) {
		return a+b;
	}

	public static String add(String a, String b) {
		return a+b;
	}
}
