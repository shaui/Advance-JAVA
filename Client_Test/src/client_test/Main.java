package client_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
//		new Client().start();
		TreeMap<String, Integer> test = new TreeMap<String, Integer> ((a, b) -> {return Math.random() > 0.5 ? 1 : -1;});
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("d", 4);

		for(int i=0; i<test.size(); i++) {
			System.out.println(test.keySet().toArray()[i] + " = " + test.values().toArray()[i]);
		}
		
	}
	
	private static ArrayList<Integer> randomSet(int num) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			int temp = (int)(Math.random()*num);	
			while(rs.contains(temp)) {
				temp = (int)(Math.random()*num);
			}
			rs.add(temp);
		}
		return rs;
	}
	
	private static ArrayList<Integer> randomSet(int num, int max) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			int temp = (int)(Math.random()*max);	
			while(rs.contains(temp)) {
				temp = (int)(Math.random()*max);
			}
			rs.add(temp);
		}
		return rs;
	}
	
	

}
