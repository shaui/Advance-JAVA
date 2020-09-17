package q1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class FPDB {

	final String DATABASE_URL = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
    private String SELECT_QUERY;
    
    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet ;
    
    private ArrayList<MemberData> members = new ArrayList<MemberData>();
    
	public FPDB() {
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
	
	public ArrayList<MemberData> selectAllData() {
		try {
			SELECT_QUERY = "SELECT * FROM people";
			resultSet = statement.executeQuery(SELECT_QUERY); //取得Data set
			
			ResultSetMetaData metaData = resultSet.getMetaData(); //取得metaData -->row(0)
			int numberOfColumns = metaData.getColumnCount();
			
//			for ( int i = 1; i <= numberOfColumns; i++ )
//	             System.out.printf( "%-10s\t", metaData.getColumnName( i ) ); //逐一print metaData
//	        System.out.println();
	        
	        while ( resultSet.next() ) //第一次next()就到row(1)
	        {
	        	members.add(new MemberData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
	        }
//	        resultSet.beforeFirst();//回到第一個
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		return members;
	}
	
	public void updateData(String memberID, String cls) {
		try {
			memberID = "'" + memberID + "'";
			cls = "'" + cls + "'";
			statement.executeUpdate("UPDATE people SET class = " + cls + " WHERE MemberId = " + memberID  );
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
}
