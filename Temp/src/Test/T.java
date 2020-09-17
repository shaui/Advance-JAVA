package Test;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T {
	public static Map<String, Boolean> clientsStatus = new HashMap<>();
	public static void main(String[] args) {
		String a = "123";
		System.out.println(a.length());
		System.out.println(a.getBytes().length);
	}

	public static double f(double[] a) {
		double t = 0;
		for(double x : a) {
			t += (x-17.28)*(x-17.28);
		}
		t = t/4;
		return t;
	}
	
	public static double f2(double[] a) {
		double t = 0;
		for(double x : a) {
			t += x*x;
		}
		t = t/4;
		t = t-17.28*17.28*5/4;
		return t;
		
	}
}
