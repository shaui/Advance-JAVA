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
		resultSet = statement.executeQuery(SELECT_QUERY); //���oData set

		metaData = resultSet.getMetaData(); //���ometaData -->row(0)
		numberOfColumns = metaData.getColumnCount();

		resultSet.last(); // move to last row ���F�o��L���X��row
		numberOfRows = resultSet.getRow(); // get row number �o�즳�X��row

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
			// TODO �۰ʲ��ͪ� catch �϶�
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
	
	@Override //���o�C�@column��class�A���F�bsetRowFilter()�ɥi�H���D�n�̷ӭ������O�ƧǡA�Ҧpint�n����int����k�ƧǡA���M�������^��default��Object���O�|����Object����k�Ƨ�
	public Class getColumnClass(int column) throws IllegalStateException{
		
		return getValueAt(0, column).getClass(); //���o�Y�@column's data �� class
	}

}
