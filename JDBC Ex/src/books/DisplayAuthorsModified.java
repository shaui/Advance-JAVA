package books;
// Fig. 24.23: DisplayAuthors.java
// Displaying the contents of the authors table.
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthorsModified 
{
   public static void main(String args[])
   {
      //final String DATABASE_URL = "jdbc:derby:books";
      final String DATABASE_URL = "jdbc:mysql://localhost:3307/books?serverTimezone=UTC";
      String SELECT_QUERY = 
         "SELECT authorID, firstName, lastName FROM authors";

      // use try-with-resources to connect to and query the database
      try {
         Connection connection = DriverManager.getConnection(
            DATABASE_URL, "root", "root"); 
    		//Statement statement = connection.createStatement();
    	    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //�i�H�W�U����
    	    		                                             ResultSet.CONCUR_UPDATABLE); //�ק諾��������DB
         ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
      
    	// process query results
          ResultSetMetaData metaData = resultSet.getMetaData();
          int numberOfColumns = metaData.getColumnCount();     
          System.out.println( "Authors Table of books Database:\n" );
          
          for ( int i = 1; i <= numberOfColumns; i++ )
             System.out.printf( "%-10s\t", metaData.getColumnName( i ) );
          System.out.println();
          
          while ( resultSet.next() ) 
          {
             for ( int i = 1; i <= numberOfColumns; i++ )
                System.out.printf( "%-10s\t", resultSet.getObject( i ) );
             System.out.println();
          } // end while
          
          resultSet.moveToInsertRow(); //����@�ӥ��]�w��Row�A�U���A���]�w
          resultSet.updateInt(1,6); //��Ĥ@�����(column)�]�w��6
          resultSet.updateString(2,"Shi-Jen");//�]�w column(2)
          resultSet.updateString(3,"Lin");//�]�w column(3)
          resultSet.insertRow(); //insert�bcursor���w���a��
//        resultSet.beforeFirst();//�^��Ĥ@��
          
          System.out.println();
          System.out.println( "After inserting a new record (in resultSet)\n" );
          metaData = resultSet.getMetaData(); //row(0)
          numberOfColumns = metaData.getColumnCount();
          for ( int i = 1; i <= numberOfColumns; i++ )
              System.out.printf( "%-10s\t", metaData.getColumnName( i ) );
          System.out.println();
          
          resultSet.beforeFirst();//�^��row(1)�e��
          while ( resultSet.next() ) 
           {
              for ( int i = 1; i <= numberOfColumns; i++ )
                 System.out.printf( "%-10s\t", resultSet.getObject( i ) );
              System.out.println();
           } // end while
          
          
          System.out.println();
          resultSet = statement.executeQuery(SELECT_QUERY); //���s���oDB���
          metaData = resultSet.getMetaData();
          numberOfColumns = metaData.getColumnCount();
          System.out.println( "After inserting a new record (in database)\n" );
          for ( int i = 1; i <= numberOfColumns; i++ )
              System.out.printf( "%-10s\t", metaData.getColumnName( i ) );
           System.out.println();
           
           while ( resultSet.next() ) 
           {
              for ( int i = 1; i <= numberOfColumns; i++ )
                 System.out.printf( "%-10s\t", resultSet.getObject( i ) );
              System.out.println();
           } // end while
           
         statement.executeUpdate("DELETE FROM authors WHERE lastName='Lin'"); //�R��
         System.out.println();
         resultSet = statement.executeQuery(            
         "SELECT authorID, firstName, lastName FROM authors" );
         metaData = resultSet.getMetaData();
         numberOfColumns = metaData.getColumnCount();
         System.out.println( "After deleting the last record\n" );
         for ( int i = 1; i <= numberOfColumns; i++ )
             System.out.printf( "%-10s\t", metaData.getColumnName( i ) );
          System.out.println();
          
          while ( resultSet.next() ) 
          {
             for ( int i = 1; i <= numberOfColumns; i++ )
                System.out.printf( "%-10s\t", resultSet.getObject( i ) );
             System.out.println();
          } // end while  
      } // AutoCloseable objects' close methods are called now 
      catch (SQLException sqlException)                                
      {                                                                  
         sqlException.printStackTrace();
      }                                                   
   } 
} // end class DisplayAuthors



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

 