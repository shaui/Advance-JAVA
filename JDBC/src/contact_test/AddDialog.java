package contact_test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDialog extends JDialog{

	private JTextField name;
	private JLabel nameTag;
	private JComboBox<String> type;
	private String[] typeName = {"Cell", "Home", "Company"};
	private JLabel phoneTag;
	private JTextField phone;
	private JButton confirm;
	
	private MembersDBMS membersDBMS = new MembersDBMS();
	private String memberID;
	
	private String typeStatus = "Cell";
	
	public AddDialog() {
		memberID = "";
		setTitle("Add Data");
		setLayout(new FlowLayout());
		setSize(250,190);
		setLocation((int)(ScreenSize.getX()*0.5)-125,(int)(ScreenSize.getY()*0.5)-150);
		setModal(true);
		
		nameTag = new JLabel("姓名:");
		name = new JTextField();
		name.setPreferredSize(new Dimension(150,30));
		
		type = new JComboBox<String>(typeName);
		type.setPreferredSize(new Dimension(200,30));
		type.addItemListener(new TypeListener());
		
		phoneTag = new JLabel("電話:");
		phone = new JTextField();
		phone.setPreferredSize(new Dimension(150,30));
		
		confirm = new JButton("Confirm");
		confirm.addActionListener(new ConfirmListener());

		add(nameTag);
		add(name);
		add(type);
		add(phoneTag);
		add(phone);
		add(confirm);
		setVisible(true);
	}
	
	public AddDialog(String ID) {
		memberID = ID;
		setTitle("Add Data");
		setLayout(new FlowLayout());
		setSize(250,190);
		setLocation((int)(ScreenSize.getX()*0.5)-125,(int)(ScreenSize.getY()*0.5)-150);
		setModal(true);
		
		nameTag = new JLabel("姓名:");
		name = new JTextField();
		name.setPreferredSize(new Dimension(150,30));
		
		type = new JComboBox<String>(typeName);
		type.setPreferredSize(new Dimension(200,30));
		type.addItemListener(new TypeListener());
		
		phoneTag = new JLabel("電話:");
		phone = new JTextField();
		phone.setPreferredSize(new Dimension(150,30));
		
		confirm = new JButton("Confirm");
		confirm.addActionListener(new ConfirmListener());
		
		add(nameTag);
		add(name);
		add(type);
		add(phoneTag);
		add(phone);
		add(confirm);
		setVisible(true);
	}
	
	public class TypeListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				typeStatus = (String)type.getSelectedItem();
				System.out.println(typeStatus);
			}
		}
	}
	
	public class ConfirmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	
			String tempName = name.getText();
			boolean nameStatus = !tempName.equals(null) && !tempName.equals("");
			
			String tempPhone = phone.getText();
			boolean phoneStatus;
			
			if(typeStatus.equals("Cell")) {
//				System.out.println(tempPhone);
				phoneStatus = tempPhone.matches("[0]{1}[9]{1}[0-9]{8}");
			}
			else {
				phoneStatus = tempPhone.matches("[0]{1}[0-9]{8,9}");
			}
			
			
			if(nameStatus && phoneStatus) {
				if(memberID.equals("")) {
					System.out.println("insert");
					membersDBMS.insertData(name.getText(), (String)type.getSelectedItem(), phone.getText());
				}
				else {
					System.out.println("update");
					membersDBMS.updateData(memberID, name.getText(), (String)type.getSelectedItem(), phone.getText());
				}
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong format");
			}
		}
		
	}
	
	
	

}
