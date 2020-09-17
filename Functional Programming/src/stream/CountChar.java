package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountChar {

	public static void main(String[] args) throws IOException {
		Pattern p = Pattern.compile("\\s+");
		Map<String, Long> sortChar =  
				Files.lines(Paths.get("test.txt")) //Files.lines : 把檔案中的每一行，一行一行的放進Stream裡面
				.map(x -> x.replaceAll("\\p{P}", "")) // \p{P}代表所有特殊符號，但因為在裡面所以要寫成 \\p{P}
//				.map(x -> x.replaceAll("\\s+", ""))
				.flatMap( x -> Arrays.stream(x.split("\\s+"))) //split後不存成String[]，而是變成一個一的Stream
				.collect(Collectors.groupingBy(Function.identity() /* x -> x */,TreeMap :: new, Collectors.counting()));
		sortChar
		.forEach((key,value) -> System.out.println(key + ": " + value));
		System.out.println();
		
		ArrayList list = (ArrayList) sortChar.entrySet()
		.stream()
		.collect(Collectors.toList());
		
		Map<String, Long> charCount = (Map<String, Long>) list.stream()
		.map(x -> x.toString().replaceAll("\\p{P}", ""))
		.map(x -> x.toString().replaceAll("1", ""))
		.flatMap(x -> Arrays.stream(x.toString().split("")))
		.collect(Collectors.groupingBy(Function.identity(),TreeMap :: new, Collectors.counting()));
		
		charCount.forEach((key,value) -> System.out.println(key + ": " + value));
		
		
		
	}
}
