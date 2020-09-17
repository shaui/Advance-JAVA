package collections_operation;

// put/get/containKey/isEmpty/size/keySet

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class MyMap {

	public static void main(String[] arge) {
		String[] key = {"id1", "id2", "id3", "id4"};
		String[] value = {"Zoue", "Shaui", "OGsin", "Zour"};
		
		HashMap<String,String> hm = new HashMap<>();
		for(int i=0; i<key.length; i++) {
			hm.put(key[i], value[i]);
		}
		System.out.println("HashMap non-order : " + hm);
		
		TreeMap<String,String> tm = new TreeMap<>();
		for(int i=0; i<key.length; i++) {
			tm.put(key[i], value[i]);
		}
		System.out.println("TreeMap are ordered by key : " + tm);
		
		if(tm.isEmpty()) {
			System.out.println("Empty map");
		}
		else {
			System.out.println("Have some element : " + tm.keySet() + " -> " + tm.entrySet());
		}
		
		System.out.println("The map size is : " + tm.size());
		
		Scanner s = new Scanner(System.in);
		System.out.print("input the key :");
		String id = s.nextLine();
		if(tm.containsKey(id)) {
			System.out.println("have the key : " + id);
		}
		else {
			System.out.println("haven't the key : " + id);
		}
		
	}
}
