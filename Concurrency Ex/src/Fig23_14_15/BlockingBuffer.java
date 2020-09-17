//ArrayBlockingQueue(類似於synchronized用法)就是把我們要的物件放進Queue裡面，如果還沒進去就呼叫時會進入blocked等待，等到放進去了才會被執行。
package Fig23_14_15;

// Fig. 23.14: BlockingBuffer.java
// Creating a synchronized buffer using the ArrayBlockingQueue class.
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer
{
   private final ArrayBlockingQueue<Integer> buffer; // shared buffer (可以共用的一個值物件) ， 可以想像成就是一個<Integer>只是他是放在Queue裡面，而且可以拿出來或是加入新的

   public BlockingBuffer()
   {
      buffer = new ArrayBlockingQueue<Integer>(1); //1代表只能放一個物件
   }
   
   // place value into buffer
   public void blockingPut(int value) throws InterruptedException
   {
      buffer.put(value); // place value in buffer //ArrayBlockingQueue.put() 如果滿了就會等待，不然就put進去
      System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value,
         "Buffer cells occupied: ", buffer.size());
   } 

   // return value from buffer
   public int blockingGet() throws InterruptedException
   {
      int readValue = buffer.take(); // remove value from buffer /ArrayBlockingQueue.get() 如果滿了就會等待，不然就get進去
      System.out.printf("%s %2d\t%s%d%n", "Consumer reads ", 
         readValue, "Buffer cells occupied: ", buffer.size());

      return readValue;
   } 
} // end class BlockingBuffer


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
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