package event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import component.module.MyButton;
import component.module.MyFrame;
import component.module.MyPanel;
/*When Enter is pressed*/
public class ActionLis implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Icon img = new ImageIcon("C:\\Users\\Jonathan\\Desktop\\JAVAcourse\\Event\\Character\\img1.jpg");
		JOptionPane.showMessageDialog(new MyButton(img),e.getActionCommand());
	}

}
