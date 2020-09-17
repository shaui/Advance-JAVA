/*set method*/
/*previous*/
package iterator_type;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListIterator_module {
	
	public static void main(String[] args) {
		LinkedList<String> li1 = new LinkedList<>();
		LinkedList<String> li2 = new LinkedList<>();
		li1.add("Name ");
		li2.add("Jonathan");
		li1.addAll(li2);
		
		ListIterator<String> it1 = li1.listIterator();
		while(it1.hasNext()) {
			it1.set(it1.next().toUpperCase());  //can use the set method
		}
		System.out.println(li1);
		
		ListIterator<String> it2 = li1.listIterator(li1.size()); // can use the previous
		while(it2.hasPrevious()) {
			System.out.print(it2.previous() + " ");
		}
		Collections.reverse(li1);
		System.out.println("\n" + li1);
		
		
	}
}
