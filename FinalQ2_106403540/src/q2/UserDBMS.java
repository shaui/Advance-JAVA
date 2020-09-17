package q2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDBMS {
	final String DATABASE_URL = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
    private String SELECT_QUERY;
    
    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet ;
    
    private UserData userData = new UserData();
    
    public UserDBMS() {
		// use try-with-resources to connect to and query the database
	    try {
	       connection = DriverManager.getConnection(
	          DATABASE_URL, "java", "java"); 
	  		//Statement statement = connection.createStatement();
	  	   statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //可以上下移動
	  	    		                                             ResultSet.CONCUR_UPDATABLE); //修改直接反應到DB
	    }
	  	catch (SQLException sqlException)                                
	    {                                                                  
	       sqlException.printStackTrace();
	    } 
	}
	
	
	public UserData searchData(String token) {
		SELECT_QUERY = "SELECT Userid, level FROM user WHERE Userid = " + "'" + token + "'" ;
		
		try {
			resultSet = statement.executeQuery(SELECT_QUERY);
			
			ResultSetMetaData metaData = resultSet.getMetaData(); //取得metaData -->row(0)
			int numberOfColumns = metaData.getColumnCount();
			resultSet.next(); //移到正確的位置
			
			//取得data並設定data
			userData.setID(resultSet.getString(1));
			userData.setLevel(resultSet.getInt(2));
	
		} catch (SQLException e) {
			userData.setID(token);
			userData.setLevel(1);
			insertData(token, 1);
			
			return userData;
		}
		return userData;
	}
	
	public void insertData(String userID, int level) {
		try {
			userID = "'" + userID + "'";
			statement.execute("ALTER TABLE people AUTO_INCREMENT = 1");
			statement.executeUpdate("INSERT INTO user ( userID, level ) VALUES ( " + userID + "," + level + " ) ");
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	public void deleteData(String userID) {
		try {
//			statement.executeUpdate("DELETE FROM authors WHERE firstName LIKE 'S%'");
//			statement.executeUpdate("DELETE FROM authors WHERE firstName LIKE '_S%'");
			statement.executeUpdate("DELETE FROM user WHERE Userid = '" + userID + "' ");
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	public void updateData(String userID, int level) {
		try {
			userID = "'" + userID + "'";
			statement.executeUpdate("UPDATE user SET level = " + level + " WHERE Userid = " + userID  );
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}

}
