package basic_operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Sel_Insert_Del {

	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/member?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
    private String SELECT_QUERY = 
       "SELECT * FROM authors";
    
    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet ;
    
    private PreparedStatement selectAllPeople; 
    private PreparedStatement selectPeopleByLastName; 
    private PreparedStatement insertNewPerson; 
	public Sel_Insert_Del() {
		
	    // use try-with-resources to connect to and query the database
	    try {
	       connection = DriverManager.getConnection(
	          DATABASE_URL, USERNAME, PASSWORD); 
	  		//Statement statement = connection.createStatement();
	  	   statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //可以上下移動
	  	    		                                             ResultSet.CONCUR_UPDATABLE); //修改直接反應到DB

	  	   selectAllPeople = 
	  			   connection.prepareStatement("SELECT * FROM Addresses");
	  	   
	  	   selectPeopleByLastName = connection.prepareStatement(
	  			   "SELECT * FROM Addresses WHERE LastName = ?");

	  	   // create insert that adds a new entry into the database
	  	   insertNewPerson = connection.prepareStatement(
	  			   "INSERT INTO Addresses " + 
	  					   "(FirstName, LastName, Email, PhoneNumber) " + 
	  			   "VALUES (?, ?, ?, ?)");
	    }
	  	catch (SQLException sqlException)                                
	    {                                                                  
	       sqlException.printStackTrace();
	    } 
	}
	
	public int addPerson(String fname, String lname, String email, String num){
		int result = 0;

		// set parameters, then execute insertNewPerson
		try 
		{
			insertNewPerson.setString(1, fname);
			insertNewPerson.setString(2, lname);
			insertNewPerson.setString(3, email);
			insertNewPerson.setString(4, num);

			// insert the new entry; returns # of rows updated
			result = insertNewPerson.executeUpdate(); 
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		} 

		return result;
	} 
	
	 public List< Object > getPeopleByLastName(String name)
	 {
		 List< Object > results = null;
		 ResultSet resultSet = null;

		 try 
		 {
			 selectPeopleByLastName.setString(1, name); // specify last name

			 // executeQuery returns ResultSet containing matching entries
			 resultSet = selectPeopleByLastName.executeQuery(); 

			 results = new ArrayList< Object >();

			 while (resultSet.next())
			 {
				/* results.add(new Object(resultSet.getInt("addressID"),
						 resultSet.getString("firstName"),
						 resultSet.getString("lastName"),
						 resultSet.getString("email"),
						 resultSet.getString("phoneNumber")));*/
			 } 
		 } 
		 catch (SQLException sqlException)
		 {
			 sqlException.printStackTrace();
		 } 
		 
		 return results;
	 } 
	
	public void selectData() {
		try {
			resultSet = statement.executeQuery(SELECT_QUERY); //取得Data set
			
			ResultSetMetaData metaData = resultSet.getMetaData(); //取得metaData -->row(0)
			int numberOfColumns = metaData.getColumnCount();   
			
			for ( int i = 1; i <= numberOfColumns; i++ )
	             System.out.printf( "%-10s\t", metaData.getColumnName( i ) ); //逐一print metaData
	        System.out.println();
	        
	        while ( resultSet.next() ) //第一次next()就到row(1)
	        {
//	        	for ( int i = 1; i <= numberOfColumns; i++ ) {
//	        		System.out.printf( "%-10s\t", resultSet.getObject( i ) ); //print data
//	        	}
	        	System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString("lastName"));
//	        	System.out.println();
	        }
//	        resultSet.beforeFirst();//回到第一個
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	public void insertData() {
		try {
			statement.execute("ALTER TABLE people AUTO_INCREMENT = 1");
			statement.executeUpdate("INSERT INTO people ( name, type, phone ) VALUES ('Anna', 'Cell', '0989525623') ");
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	public void autoInsertData() {
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //可以上下移動
			        ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(SELECT_QUERY);
			
			resultSet.moveToInsertRow(); //移到一個未設定的Row，下面再做設定
	        resultSet.updateInt(1,7); //把第一個欄位(column)設定成6
	        resultSet.updateString(2,"Shi-Jen");//設定 column(2)
	        resultSet.updateString(3,"Lin");//設定 column(3)
	        resultSet.insertRow(); //insert在cursor指定的地方
//	        resultSet.beforeFirst();//回到第一個
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		} //修改直接反應到DB
		
	}
	
	public void updateData() {
		try {
			statement.executeUpdate("UPDATE authors SET lastName = 'Deitel', firstName = 'Paul' WHERE firstName = 'A' AND lastName = 'B' ");
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	public void deleteData() {
		try {
//			statement.executeUpdate("DELETE FROM authors WHERE firstName LIKE 'S%'");
//			statement.executeUpdate("DELETE FROM authors WHERE firstName LIKE '_S%'");
			statement.executeUpdate("DELETE FROM people WHERE name LIKE 'A%' ");
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
}
