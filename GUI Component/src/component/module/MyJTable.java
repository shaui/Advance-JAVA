//用JTable要放進JScrollPane裡面，不然columnName不會跑出來，或者去用JTableHeader
package component.module;

import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.ScreenSize;

public class MyJTable extends JFrame{
	
	private MyJTableModel tableModel;
	
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3307/member?serverTimezone=UTC";
	private static final String USERNAME = "java";
	private static final String PASSWORD = "java";

	// default query retrieves all data from authors table
	private static final String SELECT_QUERY = "SELECT * FROM people";

	public MyJTable() throws SQLException {
		setLayout(new FlowLayout());
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480,640);
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);	
		
		tableModel = new MyJTableModel(DATABASE_URL, USERNAME, PASSWORD, SELECT_QUERY);
		JTable resultTable = new JTable(tableModel);
		JPanel jp = new JPanel();
		add(new JScrollPane(resultTable));
		
		setVisible(true);
	}

}
