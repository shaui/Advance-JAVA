package component.module;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RightPanel extends JPanel{

	private JLabel addLabel;
	private JButton searchBtn;
	private Icon cross = new ImageIcon(getClass().getResource("cross.png"));
	
	public RightPanel() {
		setLayout(new GridLayout(2,1,0,10));
		addLabel = new JLabel(cross);
		addLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBtnSize();
		searchBtn = new JButton("Search");
		add(addLabel);
		add(searchBtn);
	}
	
	private void setBtnSize() {
		( (ImageIcon)cross ).setImage( ( (ImageIcon)cross ).getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT) );
	
	}
	private void reBtnSize() {
		( (ImageIcon)cross ).setImage( ( (ImageIcon)cross ).getImage().getScaledInstance(getWidth()/10, getHeight()/10,Image.SCALE_DEFAULT) );

	}
}
