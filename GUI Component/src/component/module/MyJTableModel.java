package component.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class MyJTableModel extends AbstractTableModel{
	private final Connection connection;
	private final Statement statement;
	private String SELECT_QUERY;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfColumns;
	private int numberOfRows;
	
	
	public MyJTableModel(String url, String username, String password, String query) throws SQLException {
		
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		SELECT_QUERY = query;
		resultSet = statement.executeQuery(SELECT_QUERY); //取得Data set

		metaData = resultSet.getMetaData(); //取得metaData -->row(0)
		numberOfColumns = metaData.getColumnCount();

		resultSet.last(); // move to last row 為了得到他有幾個row
		numberOfRows = resultSet.getRow(); // get row number 得到有幾個row

		fireTableStructureChanged();
		
	}

	@Override //set the column number
	public int getColumnCount() {

		return numberOfColumns;
	}

	@Override //set the row numbers
	public int getRowCount() {

		return numberOfRows;
	}

	@Override //set the data
	public Object getValueAt(int row, int col) {
		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(col + 1);
		} catch (SQLException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		return "";
	}
	
	@Override //set the ColumnName
	public String getColumnName(int column) throws IllegalStateException{
				
		 try 
	      {
	         return metaData.getColumnName(column + 1);  
	      } 
	      catch (SQLException sqlException) 
	      {
	         sqlException.printStackTrace();
	      } 
	      
	      return ""; // if problems, return empty string for column name
	}
	
	@Override //取得每一column的class，為了在setRowFilter()時可以知道要依照哪種類別排序，例如int要按照int的方法排序，不然全部都回傳default的Object類別會按照Object的方法排序
	public Class getColumnClass(int column) throws IllegalStateException{
		
		return getValueAt(0, column).getClass(); //取得某一column's data 的 class
	}

}
