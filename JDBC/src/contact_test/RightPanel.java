package contact_test;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RightPanel extends JPanel{

	private JLabel addLabel;
	private JButton searchBtn;
	private Icon cross = new ImageIcon(getClass().getResource("cross.png"));
	private MembersDBMS membersDBMS = new MembersDBMS();
	
	public RightPanel() {
		setLayout(new GridLayout(2,1,0,10));
		addLabel = new JLabel(cross);
		addLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addLabel.addMouseListener(new AddListener());
		
		setBtnSize();
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new SearchListener());
		add(addLabel);
		add(searchBtn);
	}
	
	private void setBtnSize() {
		( (ImageIcon)cross ).setImage( ( (ImageIcon)cross ).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT) );
	}
	private void reBtnSize() {
		( (ImageIcon)cross ).setImage( ( (ImageIcon)cross ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );
	}
	
	private class SearchListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String token = LeftPanel.textField.getText();
//			MemberPanel.searchResult(token);
		}	
	}
	
	private class AddListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			AddDialog addPane = new AddDialog();
//			MemberPanel.updateData();		
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
