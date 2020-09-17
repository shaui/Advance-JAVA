import java.util.ArrayList;
import java.util.Collections;

public class BigInteger {
	
	static ArrayList<String> aList = new ArrayList<>();
	static ArrayList<String> bList = new ArrayList<>();
	static ArrayList<String> finalList = new ArrayList<>();
	public static void main(String[] args) {

		String a = b_int_count("9999999999","111");
		System.out.println(a);
	}
	
	//BigInteger count
	public static String b_int_count(String a, String b){
		
		String[] splitA = a.split("");
		String[] splitB = b.split("");
		
		//store each number in a
		int count = 0;
		while(count < a.length()) {
			String tempA = "";
			for(int i=0; i<8; i++) {
				tempA += splitA[count];
				count++;
				
				if(count == a.length()) {
					break;
				}
			}
			aList.add(tempA);
		}	
		//store each number in b
		count = 0;
		while(count < b.length()) {
			String tempB = "";
			for(int i=0; i<8; i++) {
				tempB += splitB[count];
				count++;
				
				if(count == b.length()) {
					break;
				}
			}
			bList.add(tempB);
		}
		//make two list have the same size
		int d;
		if(aList.size() > bList.size()) {
			d = aList.size() - bList.size();
			for(int i=0; i<d; i++) {
				bList.add("0");
			}
		}
		else {
			d = bList.size() - aList.size();
			for(int i=0; i<d; i++) {
				aList.add("0");
			}
		}
		
		//count
		int overInt = 0;
		for(int i=0; i<aList.size(); i++) {
			
			int x = Integer.valueOf(aList.get(i));
			int y = Integer.valueOf(bList.get(i));
			
			String z = String.valueOf( x + y + overInt );

			if(z.length() > 8) {
				overInt = Integer.valueOf(z.substring(0,1));
				
				z = z.substring(1, z.length());
			}
			else {
				overInt = 0;
			}
			finalList.add(z);
		}
		if(overInt != 0) {
			finalList.add(String.valueOf(overInt));
		}
		
		//convert to String
		String finalInt = "";
		Collections.reverse(finalList);
		for(int i=0; i<finalList.size(); i++) {
			finalInt += finalList.get(i);
		}

		return finalInt;	
	}
	
	
	
	
	
}
