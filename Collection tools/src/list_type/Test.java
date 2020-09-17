package list_type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String[] s1 = {"A","B","C","D"};
		List<String> list1 = new ArrayList<>(Arrays.asList(s1));
		
		System.out.println(list1);
		
		list1.remove(0);
		for(int i=0; i<s1.length; i++) {
			System.out.print(s1[i] + " ");
		}
		System.out.println("\n" + list1);
		
		List<String> list2 = Arrays.asList(s1);
		try {
			list2.remove(0);
		}
		catch(UnsupportedOperationException exption){
			System.out.println("Direct use the \"Arrays.asList\" cannot use the \"list.remove()\" method");
		}

	}

}
