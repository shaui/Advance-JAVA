//ArrayBlockingQueue(������synchronized�Ϊk)�N�O��ڭ̭n�������iQueue�̭��A�p�G�٨S�i�h�N�I�s�ɷ|�i�Jblocked���ݡA�����i�h�F�~�|�Q����C
package Fig23_14_15;

// Fig. 23.14: BlockingBuffer.java
// Creating a synchronized buffer using the ArrayBlockingQueue class.
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer
{
   private final ArrayBlockingQueue<Integer> buffer; // shared buffer (�i�H�@�Ϊ��@�ӭȪ���) �A �i�H�Q�����N�O�@��<Integer>�u�O�L�O��bQueue�̭��A�ӥB�i�H���X�өάO�[�J�s��

   public BlockingBuffer()
   {
      buffer = new ArrayBlockingQueue<Integer>(1); //1�N��u���@�Ӫ���
   }
   
   // place value into buffer
   public void blockingPut(int value) throws InterruptedException
   {
      buffer.put(value); // place value in buffer //ArrayBlockingQueue.put() �p�G���F�N�|���ݡA���M�Nput�i�h
      System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value,
         "Buffer cells occupied: ", buffer.size());
   } 

   // return value from buffer
   public int blockingGet() throws InterruptedException
   {
      int readValue = buffer.take(); // remove value from buffer /ArrayBlockingQueue.get() �p�G���F�N�|���ݡA���M�Nget�i�h
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