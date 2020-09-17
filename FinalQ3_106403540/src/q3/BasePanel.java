package q3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class BasePanel extends JPanel{
	
	private JList<String> nameList;
	private JLabel jlb;
	private String[] names;
	private String[] orderNames;
	private boolean orderStatus = false;
	private int maxCount = 12;
	private String selectedName = "";
	private Members selectedMember;
	
	private ArrayList<Members> members = new ArrayList<Members>();
	private ArrayList<String> tempList = new ArrayList<String>();
	private MembersDBMS membersDBMS;
	
	private JLabel phoneCount;
	
	private JPanel searchPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel memberPanel;
	
	//leftPanel
	private JLabel lb;
	private JTextField textField;
	
	//rightPanel
	private JLabel addLabel;
	private JButton searchBtn;
	private Icon cross = new ImageIcon(getClass().getResource("cross.png"));
//	private MembersDBMS membersDBMS = new MembersDBMS();
	
	//JComboBox
	private JComboBox<String> group;
	private ArrayList<String> groupList= new ArrayList<String>();
	private String[] groupName = {"classmate", "family", "BFF", "hate"};
	private boolean isAdd = false;
	private boolean isDelete = false;
	
	public BasePanel()
	{
		//connect to DB and set the data
		membersDBMS = new MembersDBMS();
		setData();
		
		//four Panel
		searchPanel = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		memberPanel = new JPanel();
		
		//leftPanel
		leftPanel.setLayout(new GridLayout(2,1,0,10));
		
		lb = new JLabel("Contacts");
		lb.setFont(new Font("Dialog", 1, 30));
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(350,20));
		
		leftPanel.add(lb);
		leftPanel.add(textField);
		
		//rightPanel
		rightPanel.setLayout(new GridLayout(2,1,0,10));
		
		addLabel = new JLabel(cross);
		addLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addLabel.addMouseListener(new AddListener());
		
		setBtnSize();
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new SearchListener());
		
		rightPanel.add(addLabel);
		rightPanel.add(searchBtn);
		
		//SearchPanel
		searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		searchPanel.add(leftPanel);
		searchPanel.add(rightPanel);

		//MemberPanel
		memberPanel.setLayout(new BorderLayout());
		
		jlb = new JLabel("name",SwingConstants.CENTER);
		jlb.setBorder(BorderFactory.createEtchedBorder());
		jlb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlb.setBackground(Color.BLACK);
		jlb.addMouseListener(new OrderListener());
		
		nameList = new JList<String>(names);
		nameList.setVisibleRowCount(maxCount);
		nameList.setFixedCellWidth(420);
		nameList.setFixedCellHeight(35);
		nameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		nameList.addMouseListener(new ClickListener());
		
		phoneCount = new JLabel("Number of contacts: " + names.length, SwingConstants.CENTER);
		phoneCount.setBorder(BorderFactory.createEtchedBorder());
		phoneCount.setBackground(Color.LIGHT_GRAY);
		
		memberPanel.add(jlb, BorderLayout.NORTH);
		memberPanel.add(new JScrollPane(nameList));
		memberPanel.add(phoneCount, BorderLayout.SOUTH);
		
		group = new JComboBox<String>(groupName);
		group.setPreferredSize(new Dimension(400,20));
		group.addActionListener(new SearchGroupListener());
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		add(searchPanel);
		add(group);
		add(memberPanel);
		
		setVisible(true);	
	}
	
	//set the memberList and the memberName
	private void setData() {
		members = membersDBMS.selectAllData(); //get the DB data
		for(int i=0; i<members.size(); i++) {
			tempList.add(members.get(i).getName());
		}
		names = tempList.toArray(new String[tempList.size()]);
	}
	
	private void updateData() {
		members.clear();
		tempList.clear();
		setData();
		nameList.setListData(names);
		
		phoneCount.setText("Number of contacts: " + names.length);
	}
	
	private void searchResult(String token) {
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
	
	//RightPane method
	private void setBtnSize() {
		( (ImageIcon)cross ).setImage( ( (ImageIcon)cross ).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT) );
	}
	
	//RightPane method
	private void reBtnSize() {
		( (ImageIcon)cross ).setImage( ( (ImageIcon)cross ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
	}
	
	//RightPanel Listener
	private class SearchListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String token = textField.getText();
			searchResult(token);
		}	
	}
	
	private class SearchGroupListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String token = (String)group.getSelectedItem();
			members.clear();
			tempList.clear();
			members = membersDBMS.searchGroup(token);
			for(int i=0; i<members.size(); i++) {
				tempList.add(members.get(i).getName());
			}
			names = tempList.toArray(new String[tempList.size()]);
			nameList.setListData(names);
			
			
			nameList.setListData(names);
			
			
			phoneCount.setText("Number of contacts: " + names.length);
		}
		
	}
	
	//RightPanel Listener
	private class AddListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			AddDialog addPane = new AddDialog();
			isAdd = true;
			updateData();		
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
	
	//MemberPanel Listener
	public class OrderListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(orderStatus == false) {
//				orderNames = (String[])names.clone();
				orderNames = Arrays.copyOf(names, names.length);
				Arrays.sort(orderNames);
				nameList.setListData(orderNames);
				orderStatus = true;
				jlb.setText("name ▼");
			}
			else {
				orderNames = Arrays.copyOf(names, names.length);
				nameList.setListData(orderNames);
				orderStatus = false;
				jlb.setText("name");
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
	
	//MemberPanel Listener
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
					isDelete = true;
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
