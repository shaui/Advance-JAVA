package contact_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;


public class MemberPanel extends JPanel{
	
	public static JList<String> nameList;
	private JLabel jlb;
	public static String[] names;
	private static int maxCount = 12;
	private String selectedName = "";
	private Members selectedMember;
	
	public static ArrayList<Members> members = new ArrayList<Members>();
	public static ArrayList<String> tempList = new ArrayList<String>();
	public static MembersDBMS membersDBMS;
	
	private static JLabel phoneCount;
	
//	private JPanel serachPanel;
//	private JPanel leftPanel;
//	private JPanel rightPanel;
//	
//	private JLabel lb;
//	private JTextField textField;
	
	public MemberPanel()
	{
//		serachPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
//		serachPanel.add(new LeftPanel());
//		serachPanel.add(new RightPanel());
		
		
		
		
		membersDBMS = new MembersDBMS();
		setData();

		jlb = new JLabel("name",SwingConstants.CENTER);
		jlb.setBorder(BorderFactory.createEtchedBorder());
		jlb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlb.setBackground(Color.BLACK);
		jlb.addMouseListener(new OrderListener());
		setLayout(new BorderLayout());
		add(jlb, BorderLayout.NORTH);
		nameList = new JList<String>(names);

		nameList.setVisibleRowCount(maxCount);
		nameList.setFixedCellWidth(420);
		nameList.setFixedCellHeight(35);
		nameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		add(new JScrollPane(nameList));
		nameList.addMouseListener(new ClickListener());
		
		phoneCount = new JLabel("Number of contacts: " + names.length, SwingConstants.CENTER);
		phoneCount.setBorder(BorderFactory.createEtchedBorder());
		phoneCount.setBackground(Color.LIGHT_GRAY);
		add(phoneCount, BorderLayout.SOUTH);
		
		setVisible(true);	
	}
	
	//set the memberList and the memberName
	public static void setData() {
		members = membersDBMS.selectAllData(); //get the DB data
		for(int i=0; i<members.size(); i++) {
			tempList.add(members.get(i).getName());
		}
		names = tempList.toArray(new String[tempList.size()]);
	}
	
	public static void updateData() {
		members.clear();
		tempList.clear();
		setData();
		nameList.setListData(names);
		phoneCount.setText("Number of contacts: " + names.length);
	}
	
	public static void searchResult(String token) {
		members.clear();
		tempList.clear();
		members = membersDBMS.searchData(token); //get the DB data
		for(int i=0; i<members.size(); i++) {
			tempList.add(members.get(i).getName());
		}
		names = tempList.toArray(new String[tempList.size()]);
		nameList.setListData(names);
		phoneCount.setText("Number of contacts: " + names.length);
	}
	
	public class OrderListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			Arrays.sort(names);
			nameList.setListData(names);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自動產生的方法 Stub			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自動產生的方法 Stub
		}
	}
	
	public class ClickListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int clickTimes = e.getClickCount();
			if(clickTimes == 2) {
				selectedName = names[nameList.getSelectedIndex()];
				for(int i=0; i<members.size(); i++) {
					if(selectedName.equals(members.get(i).getName())) {
						selectedMember = members.get(i);
					}
				}
				
				String[] option = {"修改", "刪除"};
				String memberID = selectedMember.getMemberID();
				String type = selectedMember.getType();
				String phone = selectedMember.getPhone();
				int select = JOptionPane.showOptionDialog(null, type + ": " + phone , "Member Data", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, null);
				if(select == 0) {
					AddDialog modify = new AddDialog(memberID);
					updateData();
//					nameList.removeListSelectionListener(nameList.getListSelectionListeners()[0]);
//					nameList.removeMouseListener(nameList.getMouseListeners()[0]);
//					nameList.addListSelectionListener(new ListListener());
//					nameList.addMouseListener(new ClickListener());
				}
				if(select == 1){
					membersDBMS.deleteData(memberID);
					updateData();
				}
//				System.out.println(select);
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自動產生的方法 Stub
		}

	}
}
