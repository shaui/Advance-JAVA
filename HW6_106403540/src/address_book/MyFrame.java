package address_book;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame() {
//		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		setTitle("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480,640);
		setLocation((int)(ScreenSize.getX()*0.5)-240,(int)(ScreenSize.getY()*0.5)-320);	
		setResizable(false);
//		add(new SearchPanel());
		add(new BasePanel());
		setVisible(true);
	}
	
	
	
}
