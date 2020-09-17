package q2;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class BasePanel extends JPanel{

	public static BloodStripe bloodStripe;
	
	//involve the BaseMaze
	public BasePanel() {
		setLayout(new BorderLayout());
		bloodStripe = new BloodStripe();
		add(bloodStripe, BorderLayout.NORTH);
		add(new IrritatingMaze());
		setVisible(true);
	}
}
