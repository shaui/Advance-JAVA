package stream;
// toUpperCase/Sorted/Reversed/compareToIgnoreCase
import java.util.Arrays;

public class MyStringStream {

	public static void main(String[] args) {
		String[] s = {"Shaui","Zoue","OGsin","Zour"};
		System.out.print("toUpperCase : ");
		Arrays.stream(s)
		.map(String :: toUpperCase)
		.map(x -> x + " ")
		.forEach(System.out :: print);
		System.out.println();
		
		System.out.print("Sorted : ");
		Arrays.stream(s)
		.sorted(String.CASE_INSENSITIVE_ORDER)
		.map(x -> x + " ")
		.forEach(System.out :: print);
		System.out.println();
		
		System.out.print("Reversed Sorted : ");
		Arrays.stream(s)
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
		.map(x -> x + " ")
		.forEach(System.out :: print);
		System.out.println();
		
		System.out.print("compareToIgnoreCase : ");
		Arrays.stream(s)
		.filter(x -> x.compareToIgnoreCase("r") > 0)
		.map(x -> x + " ")
		.forEach(System.out :: print);

	}

}
