package list_type;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListModule {
	
	public static void main(String[] args) {
		ArrayList<String> strList1 = new ArrayList<>();
		ArrayList<String> strList2 = new ArrayList<>();
		String[] myData = {"My", "name", "is", "Jonathan"};
		String[] name = {"Jonathan", "Kenny"};
		for(int i=0; i<myData.length; i++) {
			strList1.add(myData[i]);
		}
		for(int i=0; i<name.length; i++) {
			strList2.add(name[i]);
		}
		
		
		Iterator<String> list1_it = strList1.iterator();
		Iterator<String> list2_it = strList2.iterator();
		
		while(list1_it.hasNext()) {
			if(strList2.contains(list1_it.next())) {
				list1_it.remove();
			}
		}
		
		for(int i=0; i<strList1.size(); i++) {
			System.out.println(strList1.get(i));
		}
		
		
	}
	
	
	
}
