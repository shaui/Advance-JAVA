//sorted / flatMap / Array -> List / List -> Array
package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyArraysStream {

	public static void main(String[] args) {
		String[] s = {"Zoue","Zour","Shaui"};
		System.out.println("Normal order :");
		Arrays.stream(s)
		.sorted()
		.forEach(System.out::println);
		System.out.println("Reverse order :");
		Arrays.stream(s)
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
		
		System.out.println();
		
		Map<String, Integer> m = new TreeMap();
		m.put(s[0], 1);
		m.put(s[1], 2);
		m.put(s[2], 3);
		m.forEach((a,b) -> System.out.println(b));
		
		
		//flatMap
		Integer[][] ii = new Integer[5][5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				ii[i][j] = 1;
			}
		}
		System.out.println("After flatMap : " + Arrays.stream(ii)
				.flatMap(x -> Arrays.stream(x)) //flatMap只能對Integer這種類別使用，不能對int使用
				.reduce(0, (x,y) -> x+y));
		
		Integer[] x = Arrays.stream(ii)
		.flatMap(Arrays:: stream)
		.toArray(Integer[] :: new);
		
		
		//Array -> List
		String[] tt = {"6","8","10"};
		ArrayList<String> kk = new ArrayList<String>(Arrays.asList(tt));
		System.out.println(kk);
		
		ArrayList<String> stList = Arrays.stream(tt)
		.collect(Collectors.toCollection(ArrayList:: new) );
		System.out.println(stList);
		
		
		//List -> Array
		String[] stArray = stList.stream().toArray(String[]:: new);
		for(int i=0; i<stArray.length; i++) {
			System.out.println(stArray[i]);
		}
		
		
		
		
		
	}

}
