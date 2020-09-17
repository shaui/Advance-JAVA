// Predicate(filter) : true or false/
package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Lambdas {

	public static void main(String[] args) {
		Integer[] data1 = {1,2,3,4,5,8,9,11,12,15,20,22,26,29,31,33,38,39};
		Predicate<Integer> bigThenTen = x -> (x>10) ;
		System.out.println("Predicate : > 10");
		Arrays.stream(data1)
		.filter(bigThenTen)
		.forEach(x -> System.out.print(x + " "));

	}

}
