package post_tool;

// Fig. 15.11: ReadSequentialFile.java
// Reading a file of objects sequentially with ObjectInputStream
// and displaying each record.
import java.io.EOFException;     
import java.io.IOException;      
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ReadSequentialFile
{
   private ObjectInputStream input;

   public ReadSequentialFile()
   {
      openFile();
      readRecords();
      closeFile();
   } 

   // enable user to select file to open
   public void openFile()
   {
      try // open file
      {
         input = new ObjectInputStream(          
            Files.newInputStream(Paths.get("post")));
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file.");
         System.exit(1);
      } 
   }

   // read record from file
   public void readRecords()
   {

        	try {
        		PostSerializable record = (PostSerializable) input.readObject();
				System.out.println(record.getContent() + record.getEditTime() + record.getIsLike());
			} catch (ClassNotFoundException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			} 
        	
   } // end method readRecords

   // close file and terminate application
   public void closeFile()
   {
      try
      {
         if (input != null)
            input.close();
      } 
      catch (IOException ioException)
      {
         System.err.println("Error closing file. Terminating.");
         System.exit(1);
      } 
   } 
} // end class ReadSequentialFile


/*************************************************************************
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