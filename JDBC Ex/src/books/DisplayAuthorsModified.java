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
    	    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //可以上下移動
    	    		                                             ResultSet.CONCUR_UPDATABLE); //修改直接反應到DB
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
          
          resultSet.moveToInsertRow(); //移到一個未設定的Row，下面再做設定
          resultSet.updateInt(1,6); //把第一個欄位(column)設定成6
          resultSet.updateString(2,"Shi-Jen");//設定 column(2)
          resultSet.updateString(3,"Lin");//設定 column(3)
          resultSet.insertRow(); //insert在cursor指定的地方
//        resultSet.beforeFirst();//回到第一個
          
          System.out.println();
          System.out.println( "After inserting a new record (in resultSet)\n" );
          metaData = resultSet.getMetaData(); //row(0)
          numberOfColumns = metaData.getColumnCount();
          for ( int i = 1; i <= numberOfColumns; i++ )
              System.out.printf( "%-10s\t", metaData.getColumnName( i ) );
          System.out.println();
          
          resultSet.beforeFirst();//回到row(1)前面
          while ( resultSet.next() ) 
           {
              for ( int i = 1; i <= numberOfColumns; i++ )
                 System.out.printf( "%-10s\t", resultSet.getObject( i ) );
              System.out.println();
           } // end while
          
          
          System.out.println();
          resultSet = statement.executeQuery(SELECT_QUERY); //重新取得DB資料
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
           
         statement.executeUpdate("DELETE FROM authors WHERE lastName='Lin'"); //刪除
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

 