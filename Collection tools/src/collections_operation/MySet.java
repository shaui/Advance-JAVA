package collections_operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class MySet {

	public static void main(String[] args) {
		String[] s = {"Zoue", "Shaui","Zooe", "Jonathan"};
		HashSet<String> hs =new HashSet<>(Arrays.asList(s));
		System.out.println("HashSet are non-order : " + hs);
		
		TreeSet<String> ts = new TreeSet<>(Arrays.asList(s));
		System.out.println("TreeSet are in order : " + ts);
		
		System.out.println("TreeSet.headSet non-inclusive: " + ts.headSet("Shaui", false));
		System.out.println("TreeSet.headSet inclusive: " + ts.headSet("Shaui", true));
		System.out.println("TreeSet.tailSet non-inclusive: " + ts.tailSet("Shaui", false));
		System.out.println("TreeSet.tailSet inclusive: " + ts.tailSet("Shaui", true));
		
		System.out.println("First Object : " + ts.first());
		System.out.println("Last Object : " + ts.last());
		
	}
}
