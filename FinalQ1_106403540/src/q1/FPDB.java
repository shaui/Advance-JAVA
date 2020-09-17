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
	  	   statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  //�i�H�W�U����
	  	    		                                             ResultSet.CONCUR_UPDATABLE); //�ק諾��������DB
	    }
	  	catch (SQLException sqlException)                                
	    {                                                                  
	       sqlException.printStackTrace();
	    } 
	}
	
	public ArrayList<MemberData> selectAllData() {
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
	        	members.add(new MemberData(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
	        }
//	        resultSet.beforeFirst();//�^��Ĥ@��
		} catch (SQLException e) {
			// TODO �۰ʲ��ͪ� catch �϶�
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
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
	}
}
