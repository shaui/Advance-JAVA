package fig17_17;

// Fig. 17.17: StreamOfLines.java //����C�ӳ�r���Ӽƺ�X�ӡA�A�Φr����@Key���X�s��Map
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
      Pattern pattern = Pattern.compile("\\s+");  // \s = space , + : �i�H���ܦh\s
      
      // count occurrences of each word in a Stream<String> sorted by word
      Map<String, Long> wordCounts = 
         Files.lines(Paths.get("Chapter2Paragraph.txt")) //Files.lines : ���ɮפ����C�@��A�@��@�檺��iStream�̭�
              .map(line -> line.replaceAll("(?!')(?!-)(?!,) \\p{P}", "")) // \p{P}�N��Ҧ��S��Ÿ��A���]���b�̭��ҥH�n�g�� \\p{P}
              .flatMap(line -> pattern.splitAsStream(line) /*Arrays.stream(line.split("\\s+"))*/ ) //splitAsSteam �Osplit�ᤣ�s��String[]�A�ӬO�ܦ��@�Ӥ@��Stream (�b���Ҥl���O�ѦU����զ���Stream)
              .collect(Collectors.groupingBy(String::toLowerCase,
                 TreeMap::new, Collectors.counting())); 
      
      // display the words grouped by starting letter
      wordCounts.entrySet() //Because map cannot direct use stream()
         .stream()
         .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0), 
               TreeMap::new, Collectors.toList())) //Key�O�Ĥ@�Ӧr�� �AValue�O�ۦP�r����r��List
         .forEach((letter, wordList) -> 
            { 
               System.out.printf("%n%C%n", letter); //%C�ܦ��j�g
               //wordList�O�o��Map����Value --> �ۦP�r����r��List
               wordList.stream().forEach(word -> System.out.printf(
                  "%13s: %d%n", word.getKey(), word.getValue())); //�]�����ӨC�ӳ�r������n���X�{�h�֦��F�A�ҥH��word.getValue()
               													  //getKey()�BgetValue()���Ojava.util.Map.Entry�̭���method
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
