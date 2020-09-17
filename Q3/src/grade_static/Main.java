package grade_static;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	private static Scanner s;
	private static TreeMap<Integer,Integer> tm = new TreeMap<>();
	private static TreeMap<Integer,Integer> tm2 = new TreeMap<>();
	
	public static void main(String[] args) {
		readFile();
		
		for(int i=0; i<11; i++) {
			tm2.put(i, 0);
		}
		
		statistic();
		
		double total = 0;
		for(int i=0; i<tm2.size(); i++) {
			total += tm2.get(i);
		}
		double[] portion = new double[11];
		for(int i=0; i<tm2.size(); i++) {
			portion[i] = tm2.get(i)/total;
		}
		
		System.out.println("Java Grade:");
		for(int i=0; i<tm2.size()-1; i++) {
			System.out.printf("%02d-%02d:%3d %s (%05.2f%%)", i, i*10+9, tm2.get(i), "people",portion[i]*100);
			System.out.println();
		}
		System.out.printf("%5d:%3d %s (%05.2f%%)", 100, tm2.get(tm2.lastKey()), "people",portion[tm2.lastKey()]*100);
		

	}
	
	public static void readFile() {
		try {
			s = new Scanner(Paths.get("grade.txt"));
			while(s.hasNext()) {
				tm.put(s.nextInt(), s.nextInt());
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void statistic() {
		for(int i=0; i<tm.size(); i++) {
			int data = tm.get(i+1); //因為"第1個key" 是 "1"
			if(data<10) {
				int count = tm2.get(0);
				tm2.put(0, count+1);
			}
			else if(data<20) {
				int count = tm2.get(1);
				tm2.put(1, count+1);
			}
			else if(data<30) {
				int count = tm2.get(2);
				tm2.put(2, count+1);
			}
			else if(data<40) {
				int count = tm2.get(3);
				tm2.put(3, count+1);
			}
			else if(data<50) {
				int count = tm2.get(4);
				tm2.put(4, count+1);
			}
			else if(data<60) {
				int count = tm2.get(5);
				tm2.put(5, count+1);
			}
			else if(data<70) {
				int count = tm2.get(6);
				tm2.put(6, count+1);
			}
			else if(data<80) {
				int count = tm2.get(7);
				tm2.put(7, count+1);
			}
			else if(data<90) {
				int count = tm2.get(8);
				tm2.put(8, count+1);
			}
			else if(data < 100) {
				int count = tm2.get(9);
				tm2.put(9, count+1);
			}
			else {
				int count = tm2.get(10);
				tm2.put(10, count+1);
			}
		}
		
	}
	
	

	
}
