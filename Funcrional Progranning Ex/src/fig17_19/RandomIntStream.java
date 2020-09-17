package fig17_19;

// Fig. 17.19: RandomIntStream.java
// Rolling a die 6,000,000 times
import java.security.SecureRandom;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class RandomIntStream
{
   public static void main(String[] args)
   {
	 //用Random也可以
      SecureRandom random = new SecureRandom();

      // roll a die 6,000,000 times and summarize the results
      System.out.printf("%-6s%s%n", "Face", "Frequency");
      //create an IntStream
      random.ints(6_000_000, 1, 7)
            .boxed() //把IntStrean變成 Stream<Integer> 因為  groupingBy不能處理primitive data type
            .collect(Collectors.groupingBy(Function.identity(),  //Function.identity()就是用自己本身(Stream這次正在處理的東西) Ex:擲出1就是1
               Collectors.counting()))
            .forEach((face, frequency) -> //因為是map所以知道有2個值?
               System.out.printf("%-6d%d%n", face, frequency));
   } 
} // end class RandomIntStream

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
