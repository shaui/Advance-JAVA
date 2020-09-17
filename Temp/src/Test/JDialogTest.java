package Test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JDialogTest {
	private static JDialog jd;
	public JDialogTest() {
		
		jd = new JDialog();
		JButton btn = new JButton("½T©w");
		JLabel text = new JLabel("Just Monica",SwingConstants.CENTER);
		jd.setBounds(100,100,200,200);
		jd.setLayout(null);
		jd.setTitle("monica");
		text.setSize(100, 20);
		text.setBounds(jd.getWidth()/2-text.getWidth()/2,jd.getHeight()/3-50,text.getWidth(), text.getHeight());
		btn.setSize(50,30);
		btn.setBounds(jd.getWidth()/2-50,jd.getHeight()/2,100,30);
		jd.add(text, BorderLayout.CENTER);
		jd.add(btn,BorderLayout.SOUTH);
		jd.setModal(true);
		jd.setUndecorated(true);
		btn.addActionListener(new BtnLis());
		jd.setVisible(true);
		
	}
	
	public class BtnLis implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jd.dispose();
			
		}
		
	}
	
}
