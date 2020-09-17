package collections_operation;
// sort/shuffle/reverse/fill/copy/max/min/binarySearch/addAll/frequency/disjoint

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Collections_tool {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String[] data1 = {"Name", "Jonathan", "Name", "Shaui"};
		String[] data2 = {"Name", "Kenny"};
		String[] data3 = {"Name", "Zoue"};
		LinkedList list1 = new LinkedList(Arrays.asList(data1));
		LinkedList list2 = new LinkedList(Arrays.asList(data2));
		LinkedList list3 = new LinkedList(Arrays.asList(data3));
		
		Collections.sort(list1, null);
		System.out.println("Default sort result : " + list1);
		
		Collections.shuffle(list1);
		System.out.println("Shuffle result : " + list1);
		
		Collections.reverse(list1);
		System.out.println("Reverse result : " + list1);
		
		Collections.fill(list1, list2); //Can't set the array, but can set the list;
		System.out.println("Fill result : " + list1 + " the list2's element inside the list1 : " + ((LinkedList)list1.get(0) ).get(1));
		
		Collections.copy(list1, list2); //the index of each copy elements will be the same index in the new list, the remaining elements will not be changed
		System.out.println("Copy result : " + list1);
		
		System.out.println("Max result : " + Collections.max(list2));
		System.out.println("Min result : " + Collections.min(list2));
		
		int index = Collections.binarySearch(list1, "Kenny"); //if not found, return the place it should be place's index 把這個index取成負值再-1. Ex:should be in 3 then return the -3-1 = -4
		System.out.println("BinarySearch result : Kenny in Index " + index);
		
		String[] data4 = {"Zoue","Shaui","OGsin"};
		List<String> list4 = new LinkedList<String>(Arrays.asList(data4));
		String[] data5 = {"OGsin","Lonely-sky"};
		List<String> list5 = Arrays.asList(data5);
		
		System.out.println("List4: " + list4);
		System.out.println("List5: " + list5);
		Collections.addAll(list4, data5);
		System.out.println("addAll : " + list4);
		
		int frequence = Collections.frequency(list4, "OGsin");
		System.out.println("OGsin in list4 times : " + frequence);
		
		boolean disjoint = Collections.disjoint(list4, list5);
		System.out.println("list4 and list5 " + ( (disjoint) ? "haven't same element" : "have same element") );
		
		System.out.println(list4);
		list4.remove(0);
		System.out.println(list4);
		System.out.println(data4[0]);
	}

}
