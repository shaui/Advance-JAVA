package day1;

public class Add_Overload {

	public static void main(String[] args) {
		System.out.println("Adding two integers:2,3:");

		System.out.println("Adding two doubles:2.2,3.5:");
		System.out.println("Adding two strings:I love ,Java:" );
		System.out.println(add(2,3) + " "  + add(2.2,3.5) + " " + add("I love ","Java") );

	}

	public static int add(int a,int b) {
		return a+b;
		
	}
	
	public static double add(double a,double b) {
		return a+b;
		
	}
	
	public static String add(String a,String b) {
		return a + b;
	}
	
}
