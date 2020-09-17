package fig17_17;

// Fig. 17.17: StreamOfLines.java //先把每個單字的個數算出來，再用字首當作Key做出新的Map
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines
{
   public static void main(String[] args) throws IOException
   {
      // Regex that matches one or more consecutive whitespace characters
      Pattern pattern = Pattern.compile("\\s+");  // \s = space , + : 可以有很多\s
      
      // count occurrences of each word in a Stream<String> sorted by word
      Map<String, Long> wordCounts = 
         Files.lines(Paths.get("Chapter2Paragraph.txt")) //Files.lines : 把檔案中的每一行，一行一行的放進Stream裡面
              .map(line -> line.replaceAll("(?!')(?!-)(?!,) \\p{P}", "")) // \p{P}代表所有特殊符號，但因為在裡面所以要寫成 \\p{P}
              .flatMap(line -> pattern.splitAsStream(line) /*Arrays.stream(line.split("\\s+"))*/ ) //splitAsSteam 是split後不存成String[]，而是變成一個一的Stream (在此例子中是由各單詞組成的Stream)
              .collect(Collectors.groupingBy(String::toLowerCase,
                 TreeMap::new, Collectors.counting())); 
      
      // display the words grouped by starting letter
      wordCounts.entrySet() //Because map cannot direct use stream()
         .stream()
         .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0), 
               TreeMap::new, Collectors.toList())) //Key是第一個字母 ，Value是相同字首單字的List
         .forEach((letter, wordList) -> 
            { 
               System.out.printf("%n%C%n", letter); //%C變成大寫
               //wordList是這個Map中的Value --> 相同字首單字的List
               wordList.stream().forEach(word -> System.out.printf(
                  "%13s: %d%n", word.getKey(), word.getValue())); //因為本來每個單字都有算好有出現多少次了，所以有word.getValue()
               													  //getKey()、getValue()都是java.util.Map.Entry裡面的method
            });
   }
} // end class StreamOfLines

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
