package Fig23_26_27;

// Fig. 23.26: PrimeCalculator.java
// Calculates the first n primes, displaying them as they are found.
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class PrimeCalculator extends SwingWorker< Integer, Integer >
{
   private static final SecureRandom generator = new SecureRandom();
   private final JTextArea intermediateJTextArea; // displays found primes
   private final JButton getPrimesJButton; 
   private final JButton cancelJButton; 
   private final JLabel statusJLabel; // displays status of calculation
   private JProgressBar jb;
   
   private final boolean[] primes; // boolean array for finding primes
   
   // constructor
   public PrimeCalculator(int max, JTextArea intermediateJTextArea, 
      JLabel statusJLabel, JButton getPrimesJButton, 
      JButton cancelJButton, JProgressBar jb)
   {
      this.intermediateJTextArea = intermediateJTextArea;
      this.statusJLabel = statusJLabel;
      this.getPrimesJButton = getPrimesJButton;
      this.cancelJButton = cancelJButton;
      this.jb = jb;
      primes = new boolean[max]; 

      Arrays.fill(primes, true); // initialize all primes elements to true
   }

   // finds all primes up to max using the Sieve of Eratosthenes
   public Integer doInBackground()
   {
      int count = 0; // the number of primes found

      // starting at the third value, cycle through the array and put
      // false as the value of any greater number that is a multiple
      for (int i = 2; i < primes.length; i++)
      {
         if (isCancelled()) // if calculation has been canceled
            return count;
         else
         { 
//          setProgress(100 * (i + 1) / primes.length); //會產生event，觸發Listener -->隨著時間更新進度條
        	jb.setValue((100 * (i + 1) / primes.length));
            try
            { 
               Thread.sleep(generator.nextInt(5)); //把CPU讓出來，這樣Main才能印東西，不然就要等到RR的時間才停下來
            } 
            catch (InterruptedException ex)
            {
               statusJLabel.setText("Worker thread interrupted");
               return count;
            } 

            if (primes[i]) // i is prime
            {
               publish(i); // make i available for display in prime list
               ++count;

               for (int j = i + i; j < primes.length; j += i)
                  primes[j] = false; // i is not prime
            } 
         }  
      } 
      
      return count;
   } 

   // displays published values in primes list
   protected void process(List< Integer > publishedVals) //process執行前，publish的值都會存在List裡面，
   {
      for (int i = 0; i < publishedVals.size(); i++)
         intermediateJTextArea.append(publishedVals.get(i) + "\n"); //要使用append()因為每次process執行都會更新一次List。
   } 

   // code to execute when doInBackground completes
   protected void done()
   {
      getPrimesJButton.setEnabled(true); // enable Get Primes button
      cancelJButton.setEnabled(false); // disable Cancel button

      try
      {
         // retrieve and display doInBackground return value
         statusJLabel.setText("Found " + get() + " primes.");
      } 
      catch (InterruptedException | ExecutionException | 
         CancellationException ex)
      {
         statusJLabel.setText(ex.getMessage());
      } 
   }  
} // end class PrimeCalculator

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