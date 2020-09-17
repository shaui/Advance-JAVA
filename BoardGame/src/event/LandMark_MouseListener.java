package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import component.game.LandMark_Panel;

public class LandMark_MouseListener implements MouseListener {
	
	private LandMark_Panel l;
	
	public LandMark_MouseListener(LandMark_Panel l) {
		this.l = l;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		l.setEntered(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		l.setEntered(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
