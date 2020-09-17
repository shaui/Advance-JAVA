package comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortList {

	public static void main(String[] args) {
		String[] data = {"Shaui", "Zoue", "Jonathan", "Kenny" };
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList(data));
		
		Collections.sort(list1);
		System.out.println(list1);
	}
}
