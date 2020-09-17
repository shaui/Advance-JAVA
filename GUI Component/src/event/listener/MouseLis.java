package event.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseLis implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.print("X:"+e.getX()+" Y: "+e.getY());
		
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
