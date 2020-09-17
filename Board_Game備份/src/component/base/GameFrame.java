package component.base;

import javax.swing.JFrame;

import component.game.GamePanel;
import event.Controll_KeyListener;

public class GameFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public GameFrame() {
		setLayout(null);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new Controll_KeyListener());
		setContentPane(new GamePanel());
	}
}
