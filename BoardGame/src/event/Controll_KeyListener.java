package event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import component.game.GamePanel;

public class Controll_KeyListener implements KeyListener{
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			if(GamePanel.getChooseCard()) {
				GamePanel.setChooseCard(false);
				GamePanel.getCardContainer().setVisible(false);
				GamePanel.getCardInfo().setVisible(false);
				GamePanel.getCheckPanel().setVisible(false);
			}
			else {
				System.exit(0);
			}
			break;
		case KeyEvent.VK_SPACE:
			GamePanel.cast();
			break;
		case KeyEvent.VK_B:
			if(GamePanel.getBuyTime()) {
				GamePanel.setBuyTime(false);
			}
			else {
				GamePanel.setBuyTime(true);
			}
			break;
		case KeyEvent.VK_D:
			GamePanel.setDice();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
}
