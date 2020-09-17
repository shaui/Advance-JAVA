package component.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyTextArea extends MyFrame{
	JTextArea area1;
	JTextArea area2;
	JButton copybtn;
	
	public MyTextArea() {
		area1 = new JTextArea("Input the text",10,15);
		area2 = new JTextArea(10,15);
		copybtn = new JButton("copy->>");
		
		area2.setEditable(false);
		
		copybtn.addActionListener(new btnLis());
		
		add(new JScrollPane(area1));
		add(copybtn);
		add(new JScrollPane(area2));
		
		setVisible(true);
	}
	
	private class btnLis implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {	
			area2.setText(area1.getSelectedText());	
		}
		
	}
}
