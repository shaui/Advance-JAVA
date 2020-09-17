package stream;
// filter/map/sorted/distinct/forEach
// sum/average/count/max/min/reduce to/findFirst/findAny/anyMatch/allMatch/limit/range/rangeClosed/Arrays.stream + collect(Collectors.toList)/collect(Collectors.groupingBy())

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class MyIntStream {
	
	public static void main(String[] args) {
		int a = 1;
		IntStream.of(a).forEach(value -> System.out.println(value));
		
		int[] values = {0,1,2,9,44,265,1,2};
		
		IntStream.of(values)
		.filter(value -> value%2 == 0)
		.map(x -> x*x)
		.sorted()
		.forEach(value -> System.out.print(value + " "));
		System.out.println();

		IntStream.of(values)
		.filter(value -> value%2 == 0)
		.map(x -> x*x)
		.distinct() //把重複的東西刪掉，跟set很像
		.forEach(value -> System.out.print(value + " "));
		System.out.println();
		
		System.out.println("Sum : " + IntStream.of(values)
		.sum());
		
		System.out.println("Average : " + IntStream.of(values)
		.average()
		.getAsDouble());

		System.out.println("Count : " +IntStream.of(values)
		.count());
		
		System.out.println("Max : " +IntStream.of(values)
		.max().getAsInt());

		System.out.println("Min : " +IntStream.of(values)
		.min().getAsInt());
		
		System.out.println("Reduce to 平方和 : " +IntStream.of(values)
		.reduce(0, (x, y) -> x+y*y));
		
		System.out.println("Findfirst : " +IntStream.of(values)
		.filter( x -> x%2 != 0)
		.findFirst().orElse(666));
		
		System.out.println("FindAny : " +IntStream.of(values)
		.filter( x -> x%2 != 0)
		.findAny().orElse(666));
		
		System.out.println("AnyMatch : " +IntStream.of(values)
		.anyMatch( x -> x == 44));
		
		System.out.println("AllMatch : " +IntStream.of(values)
		.allMatch( x -> x%2 == 0));
		
		int[] values2 = {2,4,6,8,10};
		System.out.println("AllMatch : " +IntStream.of(values2)
		.allMatch( x -> x%2 == 0));
		
		System.out.print("Limit to size 4 : ");
		IntStream.of(values2)
		.limit(4)
		.forEach( value -> System.out.print(value + " "));
		System.out.println();
		
		System.out.print("Range : ");
		IntStream.range(1, 10)
		.forEach( x -> System.out.print(x + " "));
		
		System.out.println();
		System.out.print("RangeClosed : ");
		IntStream.rangeClosed(1, 10)
		.forEach( x -> System.out.print(x + " "));
		
		System.out.println();
		System.out.print("ToArray : ");
		int[] newArray = IntStream.of(values2)
				.filter(x -> x > 5)
				.toArray();
		for(int i=0; i<newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		System.out.print("--> " + Arrays.asList(newArray)); //toArray出來的Array不能用asList 


		Integer[] valueInteger = {2,4,6,8,10};
		System.out.println();
		System.out.print("Integer[] to List : ");
		//Collectors.toList cannot use the int[] so Arrays.stream()'s parameter cannot use int[], should use the Integer[]
		System.out.println(Arrays.stream(valueInteger) 
				.filter( x -> x%4 != 0)
				.collect(Collectors.toList()));

		Integer[] listValue = {1,3,5,7,9};
		List<Integer> list = new LinkedList<>(Arrays.asList(listValue));
		System.out.print("list.stram : ");
		list.stream()
		.filter( x -> x>=5)
		.map( x -> x*x)
		.forEach( x -> System.out.print(x + " "));
		
		System.out.println();
		double[] squrtValue = {4,9,16,25}; //cannot use the int[] because the Math.sqrt return the double
		Arrays.stream(squrtValue)
		.map(Math :: sqrt)
		.forEach(x -> System.out.print(x + " "));
	}
	
	
}
