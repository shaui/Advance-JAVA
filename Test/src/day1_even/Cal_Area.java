package day1_even;

public class Cal_Area {

	public static void main(String[] args) {
		double r = 5;
		double pi = 3.1415926; 
		
		
		double w = 10;
		double h = 5;
		
		
		double w2 = 5;
		double h2 = 10;
		
		
		System.out.println("Circle: " + calCircle(r, pi));
		System.out.println("Triangle: " + calTriangle(w,h));
		System.out.println("Rectangle: " + calRectangle(5,10));
		System.out.println("Total: " + (calCircle(r, pi) + calTriangle(w,h) + calRectangle(5,10)) );
		
		

	}

	public static double calCircle(double r, double pi) {
		return Math.pow(r, 2)*pi;
	}
	
	public static double calTriangle(double w, double h) {
		return w*h/2;
	}
	
	public static double calRectangle(double w, double h) {
		return w*h;
	}
}
