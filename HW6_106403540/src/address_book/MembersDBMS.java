package address_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MembersDBMS {
	
	final String DATABASE_URL = "jdbc:mysql://localhost:3307/member?serverTimezone=UTC";
    private String SELECT_QUERY;
    
    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet ;
    
    private ArrayList<Members> members = new ArrayList<Members>();
    
	public MembersDBMS() {
		// use try-with-resources to connect to and query the database
	    try {
	       connection = DriverManager.getConnection(
	          DATABASE_URL, "java", "java"); 
	  		//Statement statement = connection.createStatement();
	  	   statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //�i�H�W�U����
	  	    		                                             ResultSet.CONCUR_UPDATABLE); //�ק諾��������DB
	    }
	  	catch (SQLException sqlException)                                
	    {                                                                  
	       sqlException.printStackTrace();
	    } 
	}
	
	public ArrayList<Members> selectAllData() {
		try {
			SELECT_QUERY = "SELECT * FROM people";
			resultSet = statement.executeQuery(SELECT_QUERY); //���oData set
			
			ResultSetMetaData metaData = resultSet.getMetaData(); //���ometaData -->row(0)
			int numberOfColumns = metaData.getColumnCount();
			
//			for ( int i = 1; i <= numberOfColumns; i++ )
//	             System.out.printf( "%-10s\t", metaData.getColumnName( i ) ); //�v�@print metaData
//	        System.out.println();
	        
	        while ( resultSet.next() ) //�Ĥ@��next()�N��row(1)
	        {
	        	members.add(new Members(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
	        }
//	        resultSet.beforeFirst();//�^��Ĥ@��
		} catch (SQLException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
		return members;
	}
	
	public ArrayList<Members> searchData(String token) {
		
		
		//check if the token is digit
		if(token.matches("\\s*")) {
			SELECT_QUERY = "SELECT * FROM people" ;
		}
		else if(token.matches("\\d+")) {
			token = "'" + token + "%'";
			SELECT_QUERY = "SELECT * FROM people WHERE phone LIKE " + token;
		}
		else {
			token = "'" + token + "%'";
			SELECT_QUERY = "SELECT * FROM people WHERE name LIKE " + token;
		}
		
		try {
			resultSet = statement.executeQuery(SELECT_QUERY);
			
			ResultSetMetaData metaData = resultSet.getMetaData(); //���ometaData -->row(0)
			int numberOfColumns = metaData.getColumnCount();
			
			while ( resultSet.next() ) //�Ĥ@��next()�N��row(1)
	        {
	        	members.add(new Members(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
	        }
		} catch (SQLException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
		return members;
	}
	public void insertData(String name, String type, String phone) {
		try {
			name = "'" + name + "'";
			type = "'" + type + "'";
			phone = "'" + phone + "'";
			statement.execute("ALTER TABLE people AUTO_INCREMENT = 1");
			statement.executeUpdate("INSERT INTO people ( name, type, phone ) VALUES ( " + name + "," + type + "," + phone + " ) ");
		} catch (SQLException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
	
//	public void autoInsertData() {
//		try {
//			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //�i�H�W�U����
//			        ResultSet.CONCUR_UPDATABLE);
//			resultSet = statement.executeQuery(SELECT_QUERY);
//			
//			resultSet.moveToInsertRow(); //����@�ӥ��]�w��Row�A�U���A���]�w
//	        resultSet.updateInt(1,7); //��Ĥ@�����(column)�]�w��6
//	        resultSet.updateString(2,"Shi-Jen");//�]�w column(2)
//	        resultSet.updateString(3,"Lin");//�]�w column(3)
//	        resultSet.insertRow(); //insert�bcursor���w���a��
////	        resultSet.beforeFirst();//�^��Ĥ@��
//		} catch (SQLException e) {
//			// TODO �۰ʲ��ͪ� catch �϶�
//			e.printStackTrace();
//		} //�ק諾��������DB
//	}
	
	public void deleteData(String memberID) {
		try {
//			statement.executeUpdate("DELETE FROM authors WHERE firstName LIKE 'S%'");
//			statement.executeUpdate("DELETE FROM authors WHERE firstName LIKE '_S%'");
			statement.executeUpdate("DELETE FROM people WHERE MemberId = '" + memberID + "' ");
		} catch (SQLException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
	
	public void updateData(String memberID, String name, String type, String phone) {
		try {
			memberID = "'" + memberID + "'";
			name = "'" + name + "'";
			type = "'" + type + "'";
			phone = "'" + phone + "'";
			statement.executeUpdate("UPDATE people SET name = " + name + ", type = " + type + ", phone = " + phone + " WHERE MemberId = " + memberID  );
		} catch (SQLException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
	
	
}
