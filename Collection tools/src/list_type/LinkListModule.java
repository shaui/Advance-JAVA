package list_type;
//addFirst addLast addAll //§ÒArrayList ¶h§F addFirst addLast
//subList list.toArray
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkListModule {

	public static void main(String[] args) {
		String[] data1 = {"My", "name", "is", "Jonathan"};
		String[] data2 = {"Your", "name", "is", "Kenny"};
		LinkedList<String> list1 = new LinkedList<String>(Arrays.asList(data1)); //Arrays.asList.  ArrayList also can use
		LinkedList<String> list2 = new LinkedList<String>(Arrays.asList(data2));
		
		
		list1.addAll(list2);//connect the two list
		list2 = null;
		list1.addFirst("first");
		list1.addLast("last");
		
		String[] toArray = list1.toArray(new String[0]); // list toArray
		for(int i=0; i<toArray.length; i++) {
			System.out.print(toArray[i] + " ");
		}
		System.out.println();
		
		
		for(int i=0; i<list1.size(); i++) {
			String s = list1.get(i); //"get" can't change the list data
			s.toUpperCase();
			System.out.print(s + " ");
		}
		
		ListIterator<String> it = list1.listIterator();
		while(it.hasNext()) {
			it.set(it.next().toUpperCase()); // set can change the list data. But only the "ListIterator" has the set method
		}
		System.out.println("\n" + list1);

		list1.subList(4, 8).clear(); //can operate the sublist
		System.out.println(list1);
		
		ListIterator<String> list_it = list1.listIterator(list1.size()); //reverse the list by "ListIterator"
		while(list_it.hasPrevious()) {
			System.out.print(list_it.previous() + " ");
		}
		
	}
}
